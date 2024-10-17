package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class StudyCafeSeatPassTest {

    @Test
    @DisplayName("할인 가격 계산 테스트")
    void testGetDiscountPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        int discountPrice = seatPass.getDiscountPrice();

        // then
        assertThat(discountPrice).isEqualTo(1000); // 10000 * 0.1
    }

    @Test
    @DisplayName("락커 사용 불가 확인 테스트")
    void testCannotUseLocker() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        boolean result = seatPass.cannotUseLocker();

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("동일한 패스 타입 확인 테스트")
    void testIsSamePassType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        boolean result = seatPass.isSamePassType(StudyCafePassType.WEEKLY);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("패스 타입과 기간이 같은지 테스트")
    void testIsSameDurationType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 30, 5000);

        // when
        boolean result = seatPass.isSameDurationType(lockerPass);

        // then
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("패스 타입과 기간이 다른지 테스트")
    void testIsNotSameDurationType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.WEEKLY, 60, 5000);

        // when
        boolean result = seatPass.isSameDurationType(lockerPass);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("패스 타입 반환 테스트")
    void testGetPassType() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        StudyCafePassType passType = seatPass.getPassType();

        // then
        assertThat(passType).isEqualTo(StudyCafePassType.WEEKLY);
    }

    @Test
    @DisplayName("패스 기간 반환 테스트")
    void testGetDuration() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        int duration = seatPass.getDuration();

        // then
        assertThat(duration).isEqualTo(30);
    }

    @Test
    @DisplayName("패스 가격 반환 테스트")
    void testGetPrice() {
        // given
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 30, 10000, 0.1);

        // when
        int price = seatPass.getPrice();

        // then
        assertThat(price).isEqualTo(10000);
    }

}