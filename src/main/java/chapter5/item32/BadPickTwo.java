package chapter5.item32;

import java.util.concurrent.ThreadLocalRandom;

public class BadPickTwo {

    // This varargs parameter array is actually an object array at runtime.
    // Exposes a reference to its varargs parameter array can cause throwing ClassCastException.
    private static <T> T[] toArray(T...args) {
        return args;
    }

    public static <T> T[] pickTwo(T a, T b, T c) {
        return switch (ThreadLocalRandom.current().nextInt(3)) {
            case 0 -> toArray(a, b);
            case 1 -> toArray(a, c);
            case 2 -> toArray(b, c);
            default -> throw new AssertionError();
        };
    }

    public static void main(String[] args) {
        // pickTwo returns actually an object array which mismatches an expected string array.
        String[] strings = pickTwo("a", "b", "c"); // ClassCastException
    }
}
