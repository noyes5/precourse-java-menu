package menu.domain.repository;

import static menu.util.Constants.CATEGORY_INDEX_END;
import static menu.util.Constants.CATEGORY_INDEX_START;
import static menu.util.Constants.INDEX_DIFFERENCE;
import static menu.util.Constants.MAN_SELECTED_CATEGORY_SIZE;
import static menu.util.ExceptionMessage.INVALID_CATEGORY_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import menu.domain.Category;

public class CategoryRepository {
    private static final List<Category> categories = new ArrayList<>();
    private static final List<Category> selectedCategories = new ArrayList<>();

    private CategoryRepository() {
    }

    public static List<Category> getSelectedCategories() {
        return Collections.unmodifiableList(selectedCategories);
    }

    public static void add(Category category) {
        categories.add(category);
    }

    public static Category pickRandomCategory() {
        return categories.get(getRandomIndex());
    }

    private static int getRandomIndex() {
        return Randoms.pickNumberInRange(CATEGORY_INDEX_START, CATEGORY_INDEX_END) - INDEX_DIFFERENCE;
    }


    public static boolean canUpdateSelectedCategories(Category category) {
        return getCountCategory(category) < MAN_SELECTED_CATEGORY_SIZE;
    }

    private static long getCountCategory(Category category) {
        return selectedCategories.stream()
                .filter(element -> element == category)
                .count();
    }


    public static void updateSelectedCategories(Category category) {
        selectedCategories.add(category);
    }

    public static Category findCategoryByName(String name) {
        return categories.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_CATEGORY_NAME.getMessage()));
    }
}
