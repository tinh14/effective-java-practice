package chapter8.item55;

import java.util.*;

public class Collections {

    public static <E extends Comparable<E>> Optional<E> max(Collection<E> c) {
        Objects.requireNonNull(c);

        if (c.isEmpty())
            return Optional.empty();

        E max = null;

        for (E e : c) {
            if (max == null || e.compareTo(max) > 0)
                max = Objects.requireNonNull(e);
        }

        return Optional.of(max);
    }

    public static <E extends Comparable<E>> Optional<E> max2(Collection<E> c) {
        return c.stream().max(Comparator.naturalOrder());
    }

    public static void main(String[] args) {

        max(List.of(1, 2)).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Empty")
        );

        max2(List.of(1, 2)).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Empty")
        );

        Integer max = max2(new ArrayList<Integer>()).orElseThrow(() -> new IllegalArgumentException("Provided collection is empty"));
        System.out.println(max);
    }
}
