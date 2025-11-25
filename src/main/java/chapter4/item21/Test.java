package chapter4.item21;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> backingList = new ArrayList<>();
        Object lockObject = new Object();

        List<Integer> list = new SynchronizedList<>(backingList, lockObject);

        ExecutorService pool = Executors.newFixedThreadPool(2);

        Runnable writer = () -> {
            int i = 0;
            while (!Thread.currentThread().isInterrupted() && i < 10000) {
                list.add(i++);
            }
        };

        Runnable remover = () -> {
            try {
                list.removeIf(n -> n % 2 == 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        pool.submit(writer);
        pool.submit(remover);

        Thread.sleep(1000);
        pool.shutdownNow();
    }
}
