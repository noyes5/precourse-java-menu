package menu.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CategoryTest {
    @DisplayName("이름을 입력하여 카테고리 테스트")
    @Test
    void 카테고리_생성() {
        String name = "일식";
        Category category = new Category(name);
        assertThat(category.getName()).isEqualTo(name);
    }
}