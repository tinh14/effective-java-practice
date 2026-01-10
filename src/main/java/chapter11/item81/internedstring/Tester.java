package chapter11.item81.internedstring;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.UnaryOperator;

public class Tester {
    public static void test(UnaryOperator<String> operator) {
        Runnable task = () -> {
            String s = new String("abc");
            String result = operator.apply(s);
            System.out.println(System.identityHashCode(result));
        };

        ExecutorService exe = Executors.newFixedThreadPool(2);
        exe.execute(task);
        exe.execute(task);

        exe.shutdown();
    }
}
