package chapter9.item59;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.IntUnaryOperator;

public class NumberGenerator {
    static Random rnd = new Random();

    static int generate(int bound) {
        return Math.abs(rnd.nextInt()) % bound;
    }

    static int generate2(int bound) {
        return rnd.nextInt(bound);
    }

    static int generate3(int bound) {
        return ThreadLocalRandom.current().nextInt(bound);
    }

    static void print(int bound, IntUnaryOperator op) {
        int low = 0;
        for (int i = 0; i < 1000000; i++)
            if (op.applyAsInt(bound) < bound/2)
                low++;
        System.out.println(low);
    }

    public static void main(String[] args) {
        int bound = 2 * (Integer.MAX_VALUE / 3);

        print(bound, (b) -> generate(b));
        print(bound, (b) -> generate2(b));
        print(bound, (b) -> generate3(b));
    }
}
