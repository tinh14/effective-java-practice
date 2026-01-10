package chapter11.item81.timingconcurrentexecutor.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
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
        CyclicBarrier barrier = new CyclicBarrier(concurrency + 1);
        CountDownLatch done = new CountDownLatch(concurrency);

        for (int i = 0; i < concurrency; i++) {
            executor.execute(() -> {
                try {
                    barrier.await(); // Waits for peers and the main thread to be ready
                    action.run();
                    done.countDown(); // Tells the main thread we are done
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        stopwatch.start();
        try {
            barrier.await(); // Waits for all workers to be ready
            done.await(); // Waits for workers to finish their job
        } catch (InterruptedException | BrokenBarrierException e) {
            throw new RuntimeException(e);
        } finally {
            stopwatch.stop();
        }
    }
}
