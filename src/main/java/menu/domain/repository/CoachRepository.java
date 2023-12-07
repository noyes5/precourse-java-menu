package menu.domain.repository;

import static menu.util.ExceptionMessage.DUPLICATE_COACH_NAME;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import menu.domain.Coach;

public class CoachRepository {
    private static final List<Coach> coaches = new ArrayList<>();

    private CoachRepository() {
    }

    public static List<Coach> coaches() {
        return Collections.unmodifiableList(coaches);
    }

    public static void initCoach(List<String> coachNames) {
        validateDuplicate(coachNames);
        coachNames.forEach(name -> add(new Coach(name)));
    }

    private static void validateDuplicate(List<String> coachNames) {
        if (isDuplicatedName(coachNames)) {
            throw new IllegalArgumentException(DUPLICATE_COACH_NAME.getMessage());
        }
    }

    private static boolean isDuplicatedName(List<String> coachNames) {
        Set<String> uniqueNames = new HashSet<>(coachNames);
        return uniqueNames.size() != coachNames.size();
    }

    public static void add(Coach coach) {
        coaches.add(coach);
    }
}
