package chapter5.item30;

import java.util.HashSet;
import java.util.Set;

public class Union {
    public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
        Set<E> result = new HashSet<>(s1);
        result.addAll(s2);
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> s1 = Set.of(1, 2, 3);
        Set<Integer> s2 = Set.of(1, 2, 3, 4, 5);
        Set<Integer> result = union(s1, s2);

        System.out.println(result);
    }
}
