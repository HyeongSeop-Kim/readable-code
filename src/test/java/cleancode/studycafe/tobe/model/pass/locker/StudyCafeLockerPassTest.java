package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StudyCafeLockerPassTest {

    @Test
    void of() {
        StudyCafePassType passType = StudyCafePassType.FIXED;
        int duration = 30;
        int price = 10000;

        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(passType, duration, price);

        assertThat(lockerPass.getPassType()).isEqualTo(passType);
        assertThat(lockerPass.getDuration()).isEqualTo(duration);
        assertThat(lockerPass.getPrice()).isEqualTo(price);
    }

    @Test
    void isSamePassType() {
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        assertThat(lockerPass.isSamePassType(StudyCafePassType.FIXED)).isTrue();
        assertThat(lockerPass.isSamePassType(StudyCafePassType.HOURLY)).isFalse();
    }

    @Test
    void isSameDuration() {
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        assertThat(lockerPass.isSameDuration(30)).isTrue();
        assertThat(lockerPass.isSameDuration(15)).isFalse();
    }

    @Test
    void getPassType() {
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        assertThat(lockerPass.getPassType()).isEqualTo(StudyCafePassType.FIXED);
    }

    @Test
    void getDuration() {
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        assertThat(lockerPass.getDuration()).isEqualTo(30);
    }

    @Test
    void getPrice() {
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 30, 10000);

        assertThat(lockerPass.getPrice()).isEqualTo(10000);
    }
}