package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassTest {

    @DisplayName("of 팩터리 메서드로 생성 테스트")
    @Test
    void of() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;
        int duration = 30;
        int price = 10000;

        // when
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, duration, price);

        // then
        assertThat(lockerPass.getPassType()).isEqualTo(passType);
        assertThat(lockerPass.getDuration()).isEqualTo(duration);
        assertThat(lockerPass.getPrice()).isEqualTo(price);
    }

    @DisplayName("이용권 종류가 같은 경우 true를 반환한다.")
    @Test
    void isSamePassTypeWithSamePassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        // when
        boolean fixedPassType = lockerPass.isSamePassType(StudyCafePassType.FIXED);

        // then
        assertThat(fixedPassType).isTrue();
    }

    @DisplayName("이용권 종류가 다른 경우 false를 반환한다.")
    @Test
    void isSamePassTypeWithDifferentPassType() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        // when
        boolean weeklyPassType = lockerPass.isSamePassType(StudyCafePassType.WEEKLY);
        boolean hourlyPassType = lockerPass.isSamePassType(StudyCafePassType.HOURLY);

        // then
        assertThat(weeklyPassType).isFalse();
        assertThat(hourlyPassType).isFalse();
    }

    @DisplayName("기간이 같은 경우 true를 반환한다.")
    @Test
    void isSameDurationWithSameDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        // when
        boolean sameDuration = lockerPass.isSameDuration(30);

        // then
        assertThat(sameDuration).isTrue();
    }

    @DisplayName("기간이 다른 경우 false를 반환한다.")
    @Test
    void isSameDurationWithDifferentDuration() {
        // given
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        // when
        boolean differentDuration = lockerPass.isSameDuration(15);

        // then
        assertThat(differentDuration).isFalse();
    }
}