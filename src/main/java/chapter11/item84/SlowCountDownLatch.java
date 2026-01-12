package chapter11.item84;

public class SlowCountDownLatch {
    private int count;

    public SlowCountDownLatch(int count) {
        this.count = count;
    }

    public void await() {
        while (true) {
            synchronized (this) {
                if (count == 0)
                    return;
            }
        }
    }

    public void countDown() {
        synchronized (this) {
            if (count != 0)
                count--;
        }
    }
}
