package chapter11.item81.timingconcurrentexecutor.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

final class WorkerManager {
    private final int concurrency;
    private final Executor executor;
    private final Stopwatch stopwatch;

    WorkerManager(int concurrency, Executor executor, Stopwatch stopwatch) {
        this.executor = executor;
        this.concurrency = concurrency;
        this.stopwatch = stopwatch;
    }

    void run(Runnable action) {
        CountDownLatch ready = new CountDownLatch(concurrency);
        CountDownLatch start = new CountDownLatch(1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                ready.countDown();
                try {
                    start.await();
                    action.run();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    done.countDown();
                }
            });
        }

        try {
            ready.await();
            stopwatch.start();
            start.countDown();
            done.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            stopwatch.stop();
        }
    }
}
