package chapter11.item81.timingconcurrentexecutor.countdownlatch;

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
