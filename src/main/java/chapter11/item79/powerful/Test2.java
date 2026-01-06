package chapter11.item79.powerful;

import java.util.HashSet;

public class Test2 {
    public static void main(String[] args) {
        Observable<Integer> set = new Observable<>(new HashSet<>());

        set.addObserver(new Observer<>() {
            @Override
            public void added(Observable<Integer> observable, Integer element) {
                System.out.println(element);
                if (element == 10)
                    observable.removeObserver(this);
            }
        });

        for (int i = 0; i < 20; i++)
            set.add(i);
    }
}
