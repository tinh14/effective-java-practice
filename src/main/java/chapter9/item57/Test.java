package chapter9.item57;

import java.util.Iterator;
import java.util.List;

public class Test {

    // Uses traditional for loop
    private static void loop1(List<Integer> list) {
        for (int i = 0; i < list.size(); i++)
            System.out.print(list.get(i));
    }

    // Uses a stylish traditional for loop
    private static void loop2(List<Integer> list) {
        for (int i = 0, n = list.size(); i < n; i++)
            System.out.print(list.get(i));
    }

    // Uses a stylish for loop with Iterator
    private static void loop3(List<Integer> list) {
        for (Iterator<Integer> it = list.iterator(); it.hasNext(); )
            System.out.print(it.next());
    }

    // Uses while loop with Iterator
    private static void loop4(List<Integer> list) {
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext())
            System.out.print(iterator.next());
    }

    // Uses stream API
    private static void loop5(List<Integer> list) {
        list.stream().forEach(System.out::print);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        loop1(list);
        loop2(list);
        loop3(list);
        loop4(list);
        loop5(list);
    }
}
