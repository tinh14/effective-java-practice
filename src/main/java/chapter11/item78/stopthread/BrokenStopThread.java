package chapter11.item78.stopthread;

import java.util.concurrent.TimeUnit;

public class BrokenStopThread {
    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            long i = 0;
            while (!stopRequested)
                i++;
            System.out.println(i);
        });

        t.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }
}
