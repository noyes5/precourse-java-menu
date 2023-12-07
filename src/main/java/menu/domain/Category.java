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
    /*일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
    한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
    중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
    아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
    양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니*/
}
