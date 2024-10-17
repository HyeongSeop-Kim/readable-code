package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassOrderTest {

    @Test
    @DisplayName("할인된 총 가격 계산 테스트 - 락커 패스 포함")
    void getTotalPriceWithLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1); // 할인 1000원
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 5000);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(14000); // (10000 + 5000) - 1000 = 14000
    }

    @Test
    @DisplayName("할인된 총 가격 계산 테스트 - 락커 패스 없음")
    void getTotalPriceWithoutLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1); // 할인 1000원
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int totalPrice = passOrder.getTotalPrice();

        // then
        assertThat(totalPrice).isEqualTo(9000); // 10000 - 1000 = 9000
    }

    @Test
    @DisplayName("락커 패스가 있는 경우 Optional로 반환 테스트")
    void getLockerPassWithLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 5000);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        Optional<StudyCafeLockerPass> optionalLockerPass = passOrder.getLockerPass();

        // then
        assertThat(optionalLockerPass).isPresent();
        assertThat(optionalLockerPass.get()).isEqualTo(lockerPass);
    }

    @Test
    @DisplayName("락커 패스가 없는 경우 Optional로 반환 테스트")
    void getLockerPassWithoutLockerPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        Optional<StudyCafeLockerPass> optionalLockerPass = passOrder.getLockerPass();

        // then
        assertThat(optionalLockerPass).isEmpty();
    }

    @Test
    @DisplayName("좌석 패스 반환 테스트")
    void testGetSeatPass() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        StudyCafeSeatPass resultSeatPass = passOrder.getSeatPass();

        // then
        assertThat(resultSeatPass).isEqualTo(seatPass);
    }

    @Test
    @DisplayName("할인 가격 반환 테스트")
    void testGetDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1); // 할인 1000원
        StudyCafePassOrder passOrder = StudyCafePassOrder.of(seatPass, null);

        // when
        int discountPrice = passOrder.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(1000);
    }

}