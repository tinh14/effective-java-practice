package chapter8.item53.collections;

public class BadCollections {

    public static <T extends Comparable<? super T>> T min(T... args) {
        if (args.length == 0)
            throw new IllegalArgumentException("Too few arguments");

        T min = args[0];

        for (T arg : args)
            if (arg.compareTo(min) < 0)
                min = arg;

        return min;
    }

    public static void main(String[] args) {
        System.out.println(min(1, 3, 2, 5, 0));
        System.out.println((Integer) min()); // Runtime error
    }
}
