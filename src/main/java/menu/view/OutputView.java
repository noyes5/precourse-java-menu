package menu.view;

public class OutputView {
    public void printExceptionMessage(IllegalArgumentException exception) {
        System.out.println(exception.getMessage());
    }

    public void printMainMessage() {
        System.out.println(Message.APPLICATION_INTRO.message);
    }

    private enum Message {
        APPLICATION_INTRO("점심 메뉴 추천을 시작합니다.");

        private final String message;

        Message(String message) {
            this.message = message;
        }
    }
}
