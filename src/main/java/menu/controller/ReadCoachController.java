package menu.controller;

import menu.domain.state.ApplicationState;
import menu.view.InputView;
import menu.view.OutputView;

public class ReadCoachController implements ControllerHandler {
    private final InputView inputView;
    private final OutputView outputView;

    public ReadCoachController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    @Override
    public ApplicationState process() {

    }
}
