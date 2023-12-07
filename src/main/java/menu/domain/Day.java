package menu.domain;

public enum Day {
    MONDAY("월요일"),
    THUESDAY("화요일"),
    WEDNESDAY("수요일"),
    THIRSDAY("목요일"),
    FRIDAY("금요일");

    private final String name;

    Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
