package menu.controller;

import java.util.EnumMap;
import java.util.Map;
import menu.domain.state.ApplicationState;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<ApplicationState, ControllerHandler> controllers;

    public MenuController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.controllers = new EnumMap<>(ApplicationState.class);
        initializeControllers();
    }

    private void initializeControllers() {
        controllers.put(ApplicationState.INITIALIZE_MENU, new InitializeController(inputView, outputView));
        controllers.put(ApplicationState.READ_COACH_DATA, new ReadCoachController(inputView, outputView));
        controllers.put(ApplicationState.EXECUTE_MENU_RECOMMEND, new MenuRecommendController(inputView, outputView));
    }

    public void play() {
        ApplicationState state = process(ApplicationState.INITIALIZE_MENU);
        while (state.playable()) {
            state = process(state);
        }
    }

    public ApplicationState process(ApplicationState state) {
        try {
            return controllers.get(state).process();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
            return ApplicationState.APPLICATION_EXIT;
        }
    }

}