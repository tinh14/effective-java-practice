package chapter11.item79.powerful;

import java.util.HashSet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test3 {
    public static void main(String[] args) {
        Observable<Integer> set = new Observable<>(new HashSet<>());

        set.addObserver(new Observer<>() {
            @Override
            public void added(Observable<Integer> observable, Integer element) {
                System.out.println(element);
                if (element == 10) {
                    ExecutorService exe = Executors.newSingleThreadExecutor();
                    try {
                        exe.submit(() -> observable.removeObserver(this)).get(); // Deadlock
                    } catch (InterruptedException | ExecutionException e) {
                        throw new RuntimeException(e);
                    } finally {
                        exe.shutdown();
                    }
                }
            }
        });

        for (int i = 0; i < 20; i++)
            set.add(i);
    }
}
