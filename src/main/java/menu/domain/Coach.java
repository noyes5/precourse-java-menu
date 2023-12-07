package menu.domain;

import static menu.util.Constants.MAX_COACH_NAME;
import static menu.util.Constants.MIN_COACH_NAME;
import static menu.util.ExceptionMessage.INVALID_COACH_NAME;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Coach {
    private final String name;
    private final List<Menu> recommendMenus = new ArrayList<>();
    private final List<Menu> inedibleMenus = new ArrayList<>();

    public Coach(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (isCoachNameInRange(name)) {
            throw new IllegalArgumentException(INVALID_COACH_NAME.getMessage());
        }
    }

    public String getName() {
        return name;
    }

    public List<Menu> getRecommendMenus() {
        return recommendMenus;
    }

    private boolean isCoachNameInRange(String name) {
        return name.length() < MIN_COACH_NAME || name.length() > MAX_COACH_NAME;
    }

    public void addInedibleMenus(List<Menu> inputInedibleMenus) {
        this.inedibleMenus.addAll(inputInedibleMenus);
    }

    public void addRecommendMenu(Menu menu) {
        this.recommendMenus.add(menu);
    }

    public boolean isAvailableMenu(Menu menu) {
        return hasAlreadyRecommendMenus(menu) && hasNotInedibleMenus(menu);
    }

    private boolean hasNotInedibleMenus(Menu menu) {
        return !inedibleMenus.contains(menu);
    }

    public boolean hasAlreadyRecommendMenus(Menu menu) {
        return !recommendMenus.contains(menu);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Coach coach = (Coach) o;
        return Objects.equals(name, coach.name) && Objects.equals(recommendMenus, coach.recommendMenus)
                && Objects.equals(inedibleMenus, coach.inedibleMenus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, recommendMenus, inedibleMenus);
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", recommendMenus=" + recommendMenus +
                ", inedibleMenus=" + inedibleMenus +
                '}';
    }
}
