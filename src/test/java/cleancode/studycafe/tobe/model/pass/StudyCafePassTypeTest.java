package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafePassTypeTest {

    @DisplayName("이용권 타입이 고정석인 경우 true를 반환한다.")
    @Test
    void isLockerTypeShouldReturnTrueForFixedType() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        // when & then
        assertThat(passType.isLockerType()).isTrue();
    }

    @DisplayName("이용권 타입이 고정석이 아닌 경우 false를 반환한다.")
    @Test
    void isLockerTypeShouldReturnFalseForNonLockerTypes() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.HOURLY;
        StudyCafePassType weeklyPassType = StudyCafePassType.WEEKLY;

        // when & then
        assertThat(hourlyPassType.isLockerType()).isFalse();
        assertThat(weeklyPassType.isLockerType()).isFalse();
    }

    @DisplayName("이용권 타입이 고정석인 경우 false를 반환한다.")
    @Test
    void isNotLockerTypeShouldReturnFalseForFixedType() {
        // given
        StudyCafePassType passType = StudyCafePassType.FIXED;

        // when & then
        assertThat(passType.isNotLockerType()).isFalse();
    }

    @DisplayName("이용권 타입이 고정석이 아닌 경우 true를 반환한다.")
    @Test
    void isNotLockerTypeShouldReturnTrueForNonLockerTypes() {
        // given
        StudyCafePassType hourlyPassType = StudyCafePassType.HOURLY;
        StudyCafePassType weeklyPassType = StudyCafePassType.WEEKLY;

        // when & then
        assertThat(hourlyPassType.isNotLockerType()).isTrue();
        assertThat(weeklyPassType.isNotLockerType()).isTrue();
    }
}