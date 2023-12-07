package menu.controller;

import menu.domain.state.ApplicationState;

public interface ControllerHandler {

    ApplicationState process();

}
