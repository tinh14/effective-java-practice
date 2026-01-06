package chapter11.item80.oldworkqueue;

import java.util.LinkedList;
import java.util.Queue;

public class WorkQueue {
    private final Queue<Runnable> tasks = new LinkedList<>();
    private boolean stopped = false;

    public WorkQueue(){
        new WorkerThread().start();
    }

    public final void enqueue(Runnable task) {
        synchronized (tasks) {
            tasks.add(task);
            tasks.notify();
        }
    }

    public final void stop() {
        synchronized (tasks) {
            stopped = true;
            tasks.notify();
        }
    }

    class WorkerThread extends Thread {

        @Override
        public void run() {
            while (true) {
                Runnable task;
                synchronized (tasks) {
                    try {
                        while (tasks.isEmpty() && !stopped)
                            tasks.wait();
                    } catch (InterruptedException e) {
                        return;
                    }

                    // Ensures gracefully stop
                    if (stopped && tasks.isEmpty()) return;

                    task = tasks.poll();
                }

                try {
                    task.run();
                } catch (RuntimeException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
