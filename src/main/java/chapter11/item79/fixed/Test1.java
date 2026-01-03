package chapter11.item79.fixed;

import java.util.HashSet;

public class Test1 {
    public static void main(String[] args) {
        Observable<Integer> observable = new Observable<>(new HashSet<>());
        observable.addObserver((o, e) -> System.out.println(e));

        for (int i = 0; i < 100; i++)
            observable.add(i);
    }
}
