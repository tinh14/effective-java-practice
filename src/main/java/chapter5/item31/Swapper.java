package chapter5.item31;

import java.util.ArrayList;
import java.util.List;

public final class Swapper {
    public static void swap(List<?> list, int i, int j) {
//        list.set(i, list.set(j, list.get(i))); // Cannot modify directly with wildcard type parameter
        swapHelper(list, i, j);
    }

    private static <E> void swapHelper(List<E> list, int i, int j) {
        list.set(i, list.set(j, list.get(i))); // list.set() method returns the old value after setting the new value.
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2));
        swap(list, 0, 1);
        System.out.println(list);

        List<Object> list2 = new ArrayList<>(List.of(1, "abc"));
        swap(list2, 0, 1);
        System.out.println(list2);
    }
}
