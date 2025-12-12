package chapter6.item38;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;

public class Test {

    private static <T extends Enum<T> & Operation> void test(Class<T> type, double x, double y) {
        for (Operation o : type.getEnumConstants())
            System.out.printf("%f %s %f = %f%n", x, o, y, o.apply(x, y));
    }

    // A bit more flexible test
    private static void test(Collection<? extends Operation> operations, double x, double y) {
        for (Operation o : operations)
            System.out.printf("%f %s %f = %f%n", x, o, y, o.apply(x, y));
    }

    public static void main(String[] args) {
        double x = 4;
        double y = 2;
        System.out.println("Bounded wildcard token type");
        test(BasicOperation.class, x, y);
        test(ExtendedOperation.class, x, y);
        System.out.println("Bounded wildcard type");
        test(Arrays.asList(BasicOperation.values()), x, y);
        test(Arrays.asList(ExtendedOperation.values()), x, y);
        System.out.println("Bounded wildcard type");
        test(Set.of(BasicOperation.values()), x, y);
        test(Set.of(ExtendedOperation.values()), x, y);
    }
}
