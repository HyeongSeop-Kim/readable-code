package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @DisplayName("of 팩터리 메서드로 생성 테스트")
    @Test
    void of() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        int duration = 30;
        int price = 10000;
        double discountRate = 0.1;
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(passType, duration, price, discountRate);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, duration, price);

        // when
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // then
        assertThat(passOrder.getSeatPass())
                .extracting("passType", "duration", "price", "discountRate")
                .contains(passType, duration, price, discountRate);

        assertThat(passOrder.getLockerPass())
                .isPresent()
                .get()
                .extracting("passType", "duration", "price")
                .contains(passType, duration, price);
    }

    @Test
    @DisplayName("락커 이용권이 포함된 경우 총 가격은 (락커 이용권 가격 + 좌석 이용권 가격 - 할인 가격) 이다.")
    void getTotalPriceWithLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 30, 10000, 0.1); // 할인 1000원
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 5000);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(14000);
    }

    @Test
    @DisplayName("락커 이용권이 포함되지 않은 경우 총 가격은 (좌석 이용권 가격 - 할인 가격) 이다.")
    void getTotalPriceWithoutLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1); // 할인 1000원
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(9000);
    }

    @Test
    @DisplayName("락커 이용권이 있는 경우 Optional에 담아서 반환한다.")
    void getLockerPassWithLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 30, 10000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 5000);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        Optional<StudyCafeLockerPass> optionalLockerPass = passOrder.getLockerPass();

        // then
        assertThat(optionalLockerPass)
                .isPresent()
                .contains(lockerPass);
    }

    @Test
    @DisplayName("락커 이용권이 null인 경우 빈 Optional 객체를 반환한다.")
    void getLockerPassWithoutLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        Optional<StudyCafeLockerPass> optionalLockerPass = passOrder.getLockerPass();

        // then
        assertThat(optionalLockerPass).isEmpty();
    }
}