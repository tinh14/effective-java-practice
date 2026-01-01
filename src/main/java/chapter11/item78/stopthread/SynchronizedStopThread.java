package chapter11.item78.stopthread;

import java.util.concurrent.TimeUnit;

public class SynchronizedStopThread {
    private static boolean stopRequested;

    private static synchronized void stop() {
        stopRequested = true;
    }

    private static synchronized boolean stopRequested() {
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(() -> {
            long i = 0;
            while (!stopRequested())
                i++;
            System.out.println(i);
        });

        t.start();

        TimeUnit.SECONDS.sleep(1);
        stop();
    }
}
