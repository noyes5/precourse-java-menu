package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Category {
    private String name;
    private List<Menu> menus = new ArrayList<>();

    public Category(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Menu pickRandomMenuInCategory() {
        String menu = Randoms.shuffle(convertMenuToName()).get(0);
        return Menus.findMenuByName(menu);
    }

    private List<String> convertMenuToName() {
        return menus.stream()
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Category category = (Category) o;
        return Objects.equals(name, category.name) && Objects.equals(menus, category.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, menus);
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", menus=" + menus +
                '}';
    }

    public void addMenusToCategory(List<Menu> menus) {
        this.menus.addAll(menus);
    }
}
