package chapter5.item31;

import java.util.HashSet;
import java.util.Set;

public final class Union {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = Set.of(1, 3, 5);
        Set<Double> s2 = Set.of(1.0, 2.0, 4.0, 6.0);
        Set<Number> result = union(s1, s2); // works perfectly

        // Prior to Java 8
        Set<Number> result2 = Union.<Number>union(s1, s2);

        System.out.println(result);
        System.out.println(result2);
    }
}
