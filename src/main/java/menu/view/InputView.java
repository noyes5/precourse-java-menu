package menu.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import menu.util.InputValidator;
import menu.util.StringUtils;

public class InputView {
    public List<String> readCoachNames() {
        System.out.println(Message.INPUT_COACH_NAMES.message);
        List<String> coaches = StringUtils.splitByComma(Console.readLine());
        InputValidator.validateCoach(coaches);
        return coaches;
    }

    public List<String> readInedibleMenus(String name) {
        System.out.printf(Message.INPUT_INEDIBLE_MENUS.message, name);
        List<String> inEdibleMenus = StringUtils.splitByComma(Console.readLine());
        InputValidator.validateInEdibleMenus(inEdibleMenus);
        return inEdibleMenus;
    }

    private enum Message {
        INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)"),
        INPUT_INEDIBLE_MENUS("%s(이)가 못 먹는 메뉴를 입력해 주세요.\n");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
