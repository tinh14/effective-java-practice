package chapter2.item3.staticfactorymethod;

import java.util.Objects;

public class Test {

    public static void main(String[] args) {

        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();

            Elvis elvis = Elvis.getInstance();

            ElvisV2 elvisV2 = ElvisV2.getInstance();

            System.out.printf("%s -> Elvis: %s | ElvisV2: %s%n",
                    threadName,
                    Objects.hashCode(elvis),
                    Objects.hashCode(elvisV2));
        };

        System.out.println("Threading test:");

        for (int i = 0; i < 10; i++) {
            Thread t = new Thread(task, "Thread-" + (i + 1));
            t.start();
        }
    }
}
