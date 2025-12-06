package chapter5.item31;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.JapaneseChronology;
import java.time.chrono.JapaneseDate;
import java.time.chrono.ThaiBuddhistDate;
import java.util.*;

public final class Collections {

    public static <E extends Comparable<? super E>> Optional<E> max(Collection<? extends E> coll) {
        Objects.requireNonNull(coll);

        if (coll.isEmpty())
            return Optional.empty();

        E result = null;
        for (E e : coll) {
            if (result == null || e.compareTo(result) > 0) {
                result = Objects.requireNonNull(e);
            }
        }

        return Optional.of(result);
    }

    public static void main(String[] args) {

        List<ChronoLocalDate> coll = List.of(
                LocalDate.of(2025, 12, 7),
                ThaiBuddhistDate.of(2568, 12, 6) // ISO +543 years -> 2025
        );

        max(coll).ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Collection is empty")
        );

    }
}
