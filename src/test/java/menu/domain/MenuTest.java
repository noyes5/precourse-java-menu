package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuTest {
    @DisplayName("같은 이름이면 같은 메뉴 테스트")
    @Test
    void 동일_메뉴_검증() {
        Menu menu1 = new Menu("규동");
        Menu menu2 = new Menu("규동");
        assertThat(menu1).isEqualTo(menu2);
    }
}