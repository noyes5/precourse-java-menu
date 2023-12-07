package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachTest {

    @DisplayName("이름을 입력하여 코치 테스트")
    @Test
    void 코치_생성() {
        String name = "포비";
        Coach coach = new Coach(name);
        assertThat(coach.getName()).isEqualTo(name);
    }
}