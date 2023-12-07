package menu.view;

import static menu.util.Constants.DELIMITER;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import menu.domain.Category;
import menu.domain.Coach;
import menu.domain.Day;
import menu.domain.Menu;

public class OutputView {
    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printMainMessage() {
        System.out.println(Message.APPLICATION_INTRO.message);
    }

    public void printResult(List<Category> categories, List<Coach> coaches) {
        System.out.println(Message.MENU_RESULT_INTRO.message);
        System.out.printf(Message.DAY_FORMAT.message, formatDelimiters(Arrays.stream(Day.values()).map(Day::getName)));
        System.out.printf(Message.CATEGORIES_FORMAT.message,
                formatDelimiters(categories.stream().map(Category::getName)));
        coaches.forEach(
                coach -> System.out.printf(Message.MENUS_FORMAT.message, coach.getName(),
                        formatDelimiters(coach.getRecommendMenus().stream().map(
                                Menu::getName))));
        System.out.println(Message.RECOMMENDATION_OUTRO.message);
    }

    private String formatDelimiters(Stream<String> element) {
        return element.collect(Collectors.joining(DELIMITER));
    }

    private enum Message {
        APPLICATION_INTRO("점심 메뉴 추천을 시작합니다."),
        MENU_RESULT_INTRO("\n메뉴 추천 결과입니다."),
        DAY_FORMAT("[ 구분 | %s ]\n"),
        CATEGORIES_FORMAT("[ 카테고리 | %s ]\n"),
        MENUS_FORMAT("[ %s | %s ]\n"),
        RECOMMENDATION_OUTRO("\n추천을 완료했습니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
