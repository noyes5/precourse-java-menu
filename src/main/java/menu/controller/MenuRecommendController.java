package menu.controller;

import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;
import menu.domain.repository.CategoryRepository;
import menu.domain.repository.CoachRepository;
import menu.domain.state.ApplicationState;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuRecommendController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public MenuRecommendController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationState process() {
        for (int i = 0; i < Day.values().length; i++) {
            getRandomCategoryAndAddMenu();
        }
        outputView.printResult(CategoryRepository.getSelectedCategories(), CoachRepository.coaches());
        return ApplicationState.APPLICATION_EXIT;
    }

    private void getRandomCategoryAndAddMenu() {
        Category pickCategory = getCategory();
        for (Coach coach : CoachRepository.coaches()) {
            Menu menu = pickRandomMenu(pickCategory, coach);
            coach.addRecommendMenu(menu);
        }
        CategoryRepository.updateSelectedCategories(pickCategory);
    }

    private Category getCategory() {
        while (true) {
            Category pickCategory = CategoryRepository.pickRandomCategory();
            if (CategoryRepository.canUpdateSelectedCategories(pickCategory)) {
                return pickCategory;
            }
        }
    }

    private Menu pickRandomMenu(Category pickCategory, Coach coach) {
        while (true) {
            Menu menu = pickCategory.pickRandomMenuInCategory();
            if (coach.isAvailableMenu(menu)) {
                return menu;
            }
        }
    }
}
