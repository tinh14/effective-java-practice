package chapter11.item80.oldworkqueue;

public class Test {
    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 3; i++)
                System.out.print(i + 1);
            System.out.println();
        };
        WorkQueue queue = new WorkQueue();
        for (int i = 0; i < 5; i++)
            queue.enqueue(task);
        queue.stop();
    }
}
