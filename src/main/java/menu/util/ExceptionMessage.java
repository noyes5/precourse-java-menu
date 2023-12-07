package menu.util;

public enum ExceptionMessage {
    DUPLICATE_COACH_NAME("같은 코치명은 입력할수 없습니다."),
    INVALID_CATEGORY_NAME("카테고리를 찾을 수 없습니다."),
    INVALID_COACH_NAME( "코치 이름은 2글자 이상 4글자 이하여야 합니다."),
    INVALID_COACH_NUMBER("코치는 최소 2명 이상 입력해야 합니다."),
    INVALID_COACH_SIZE("코치는 2명부터 5명까지 입력 가능합니다."),
    INVALID_INEDIBLE_MENU_SIZE("못 먹는 메뉴는 0개부터 2개까지 입력 가능합니다."),
    INVALID_INPUT("입력은 한글만 가능합니다."),
    INVALID_MENU_NAME("해당하는 메뉴를 찾을 수 없습니다.");

    private String message;
    private static final String BASE_MESSAGE = "[ERROR] %s";

    ExceptionMessage(String message) {
        this.message = String.format(BASE_MESSAGE, message);
    }

    public String getMessage() {
        return message;
    }
}
