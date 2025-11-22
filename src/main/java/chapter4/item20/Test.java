package chapter4.item20;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        List<Integer> list = new IntArray(a);
        System.out.println(list.size());

        Collections.shuffle(list);
        System.out.println("shuffled: " + list);

        list.sort(Comparator.reverseOrder());
        System.out.println("reversed order:" + list);

    }
}
