package menu.domain;

import static menu.util.ExceptionMessage.INVALID_MENU_NAME;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private static final List<String> JAPAN_MENUS = List.of("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼");
    private static final List<String> KOREA_MENUS = List.of("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음");
    private static final List<String> CHINA_MENUS = List.of("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채");
    private static final List<String> ASIAN_MENUS = List.of("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜");
    private static final List<String> WESTERN_MENUS = List.of("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니");

    private static final List<List<String>> initMenus = new ArrayList<>();

    static {
        initMenus.add(JAPAN_MENUS);
        initMenus.add(KOREA_MENUS);
        initMenus.add(CHINA_MENUS);
        initMenus.add(ASIAN_MENUS);
        initMenus.add(WESTERN_MENUS);
    }

    private static final List<Menu> menus = new ArrayList<>();

    public static void add(Menu menu) {
        menus.add(menu);
    }

    public static List<List<String>> getInitMenus() {
        return List.copyOf(initMenus);
    }


    public static Menu findMenuByName(String name) {
        return menus.stream()
                .filter(element -> element.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MENU_NAME.getMessage()));
    }
}
