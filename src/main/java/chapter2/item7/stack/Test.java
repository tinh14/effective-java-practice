package chapter2.item7.stack;

public class Test {

    private static final int total = 1_000_000;

    private static void testStack(AbstractStack stack) throws InterruptedException {

        for (int i = 0; i < total; i++) {
            stack.push(new byte[1024]);
        }

        while (!stack.isEmpty()) {
            stack.pop();
        }

        System.out.println("Stack operations done. Waiting for checking VisualVM");
        Thread.sleep(10000);

        System.gc(); // Enforce GC to run
        Thread.sleep(5000); // wait for GC to run

        Thread.sleep(20000); // Time to capture snapshot
    }

    public static void main(String[] args) throws InterruptedException {

        // Memory leaks do not manifest themselves as obvious failures.
        // So, We need to use debugging tool like VisualVM to see heap memory usage.

//        testStack(new SmartStack());

        testStack(new DumpStack());
    }
}
