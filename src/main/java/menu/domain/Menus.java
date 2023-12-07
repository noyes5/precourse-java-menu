package menu.domain;

import static menu.util.ExceptionMessage.INVALID_MENU_NAME;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private static final List<Menu> menus = new ArrayList<>();

    public static void add(Menu menu) {
        menus.add(menu);
    }

    public static Menu findMenuByName(String name) {
        return menus.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU_NAME.getMessage()));
    }
}
