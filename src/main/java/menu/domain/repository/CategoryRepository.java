package menu.domain.repository;

import static menu.util.ExceptionMessage.INVALID_CATEGORY_NAME;

import java.util.ArrayList;
import java.util.List;
import menu.domain.Category;

public class CategoryRepository {
    private static final List<Category> categories = new ArrayList<>();

    private CategoryRepository() {
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static Category findCategoryByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_NAME.getMessage()));
    }
}
