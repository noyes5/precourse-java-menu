package menu.util;

import static menu.util.Constants.MAX_COACH_SIZE;
import static menu.util.Constants.MIN_COACH_SIZE;
import static menu.util.ExceptionMessage.INVALID_COACH_SIZE;
import static menu.util.ExceptionMessage.INVALID_INPUT;

import java.util.List;
import java.util.regex.Pattern;

public class InputValidator {
    public static final Pattern HANGLE_REGEX = Pattern.compile("^[가-힇]*$");

    public static void validateInput(String input) {
        if (!HANGLE_REGEX.matcher(input).matches()) {
            throw new IllegalArgumentException(INVALID_INPUT.getMessage());
        }
    }

    public static void validateCoach(List<String> coaches) {
        if (coaches.size() < MIN_COACH_SIZE || coaches.size() > MAX_COACH_SIZE) {
            throw new IllegalArgumentException(INVALID_COACH_SIZE.getMessage());
        }
        coaches.forEach(InputValidator::validateInput);
    }
}
