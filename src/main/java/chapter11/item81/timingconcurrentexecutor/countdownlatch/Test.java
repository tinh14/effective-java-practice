package chapter11.item81.timingconcurrentexecutor.countdownlatch;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        int concurrency = 200;
        int poolSize = 200;
        Runnable action = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("DONE");
        };
        Timer timer = new Timer(concurrency, poolSize);
        long time = timer.time(action);
        System.out.println(time);
        System.out.println(Duration.ofNanos(time).getSeconds() + " seconds");
    }
}
