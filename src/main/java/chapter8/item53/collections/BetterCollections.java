package chapter8.item53.collections;

public class BetterCollections {

    public static <T extends Comparable<? super T>> T min(T firstArg, T... args) {
        T min = firstArg;

        for (T arg : args)
            if (arg.compareTo(min) < 0)
                min = arg;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 3, 2, 5, 0));
//        System.out.println((Integer) min()); // Compile-time error
    }
}
