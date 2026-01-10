package chapter11.item81.timingconcurrentexecutor.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class Timer {
    private final ExecutorService executor;
    private final Stopwatch stopwatch;
    private final WorkerManager workerManager;

    public Timer(int concurrency, int poolSize) {
        if (concurrency > poolSize)
            throw new IllegalArgumentException("concurrency must not be greater than poolSize");
        this.executor = Executors.newFixedThreadPool(poolSize);
        this.stopwatch = new Stopwatch();
        this.workerManager = new WorkerManager(concurrency, executor, stopwatch);
    }

    public long time(Runnable action) {
        workerManager.run(action);
        executor.shutdown();
        return stopwatch.durationNanos();
    }
}

