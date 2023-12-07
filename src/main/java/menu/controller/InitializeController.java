package menu.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.repository.CategoryRepository;
import menu.domain.state.ApplicationState;
import menu.view.InputView;
import menu.view.OutputView;

public class InitializeController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    private static final List<String> CATEGORIES = Arrays.asList("일식", "한식", "중식", "아시안", "양식");
    private static final Map<String, List<String>> ALL_MENUS = new HashMap<>();

    static {
        ALL_MENUS.put("일식", List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼"));
        ALL_MENUS.put("한식", List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음"));
        ALL_MENUS.put("중식", List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채"));
        ALL_MENUS.put("아시안", List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜"));
        ALL_MENUS.put("양식", List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니"));
    }

    public InitializeController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationState process() {
        initializeCategories();
        initializeMenus();
        return ApplicationState.READ_COACH_DATA;
    }

    private void initializeCategories() {
        CATEGORIES.stream().map(Category::new).forEach(CategoryRepository::add);
    }

    private void initializeMenus() {
        ALL_MENUS.forEach((category, menuList) -> {
            addCategory(category);
            addMenusToCategory(category, menuList);
        });
    }

    private void addCategory(String categoryName) {
        CategoryRepository.add(new Category(categoryName));
    }

    private void addMenusToCategory(String categoryName, List<String> menuList) {
        List<Menu> menusInCategory = getMenus(menuList);
        menusInCategory.forEach(Menus::add);
        Category category = CategoryRepository.findCategoryByName(categoryName);
        category.addMenusToCategory(menusInCategory);
    }

    private List<Menu> getMenus(List<String> menus) {
        return menus.stream().map(Menu::new).collect(Collectors.toList());
    }
}
