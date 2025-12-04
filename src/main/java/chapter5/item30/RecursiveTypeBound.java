package chapter5.item30;

import java.util.*;

public class RecursiveTypeBound {

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

    public static void main(String[] args) {

        // Prints 2
        max(List.of(1, 2)).ifPresentOrElse(
                System.out::print,
                () -> System.out.println("Empty")
        );

        // Prints "Empty"
        max(new ArrayList<Integer>()).ifPresentOrElse(
                System.out::print,
                () -> System.out.print("Empty")
        );

        try {
            // Throws NullPointerException
            max(null).ifPresentOrElse(
                    System.out::print,
                    () -> System.out.print("Empty")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // Throws NullPointerException
            max(List.of(1, 2, null)).ifPresentOrElse(
                    System.out::print,
                    () -> System.out.print("Empty")
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
