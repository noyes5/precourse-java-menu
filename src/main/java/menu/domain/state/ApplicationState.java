package menu.domain.state;

public enum ApplicationState {
    INITIALIZE_MENU,
    READ_COACH_DATA,
    EXECUTE_MENU_RECOMMEND,
    APPLICATION_EXIT;

    public boolean playable() {
        return this != APPLICATION_EXIT;
    }
}
