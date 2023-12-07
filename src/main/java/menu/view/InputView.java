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
        System.out.println(coaches.size());
        return coaches;
    }

    private enum Message {
        INPUT_COACH_NAMES("코치의 이름을 입력해 주세요. (, 로 구분)");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
