package chapter11.item81.timingconcurrentexecutor.cyclicbarrier;

final class Stopwatch {

    private long durationNanos;

    Stopwatch() {}

    void start() {
        durationNanos = System.nanoTime();
    }

    void stop() {
        durationNanos = System.nanoTime() - durationNanos;
    }

    public long durationNanos() {
        return durationNanos;
    }
}
