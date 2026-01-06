package chapter11.item80.newworkqueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 3; i++)
                System.out.print(i + 1);
            System.out.println();
        };

        ExecutorService executor = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            executor.execute(task);
        }

        executor.shutdown();
    }
}
