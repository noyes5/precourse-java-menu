package menu.controller;

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

    }
}
