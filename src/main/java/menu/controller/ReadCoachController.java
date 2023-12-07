package menu.controller;

import java.util.List;
import java.util.stream.Collectors;
import menu.domain.Coach;
import menu.domain.Menu;
import menu.domain.Menus;
import menu.domain.repository.CoachRepository;
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
        outputView.printMainMessage();
        List<Coach> coaches = readCoachNames();
        addCoachInedibleMenus(coaches);
        return ApplicationState.EXECUTE_MENU_RECOMMEND;
    }

    private List<Coach> readCoachNames() {
        while (true) {
            try {
                List<String> coachNames = inputView.readCoachNames();
                CoachRepository.initCoach(coachNames);
                return CoachRepository.coaches();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void addCoachInedibleMenus(List<Coach> coaches) {
        for (Coach coach : coaches) {
            List<Menu> inedibleMenus = readInedibleMenu(coach);
            coach.addInedibleMenus(inedibleMenus);
        }
    }

    private List<Menu> readInedibleMenu(Coach coach) {
        while (true) {
            try {
                List<String> inedibleMenuNames = inputView.readInedibleMenus(coach.getName());
                return findMenusByName(inedibleMenuNames);
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private static List<Menu> findMenusByName(List<String> inedibleMenus) {
        return inedibleMenus.stream()
                .map(Menus::findMenuByName)
                .collect(Collectors.toList());
    }

    private static List<Coach> convertNameToCoach(List<String> coachNames) {
        return coachNames.stream().map(Coach::new).collect(Collectors.toList());
    }
}
