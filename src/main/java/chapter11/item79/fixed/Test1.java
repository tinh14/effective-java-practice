package chapter11.item79.fixed;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        Observable<Integer> set = new Observable<>(new HashSet<>());

        set.addObserver((observable, element) -> System.out.println(element));

        for (int i = 0; i < 20; i++)
            set.add(i);
    }
}
