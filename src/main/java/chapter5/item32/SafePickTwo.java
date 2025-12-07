package chapter5.item32;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class SafePickTwo {
    public static <T> List<T> pickTwo(T a, T b, T c) {
        return switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> Arrays.asList(a, b); // Using List.of for an unmodifiable list instead.
            case 1 -> Arrays.asList(a, c);
            case 2 -> Arrays.asList(b, c);
            default -> throw new AssertionError();
        };
    }

    public static void main(String[] args) {
        List<String> strings = pickTwo("a", "b", "c");
        strings.set(0, "f");
        System.out.println(strings);
    }
}
