package chapter11.item79.better;

import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        Observable<Integer> observable = new Observable<>(new HashSet<>());

        observable.addObserver(new Observer<>() {
            @Override
            public void added(Observable<Integer> observable, Integer element) {
                System.out.println(element);
                if (element == 23)
                    observable.removeObserver(this);
            }
        });

        for (int i = 0; i < 100; i++)
            observable.add(i);
    }
}
