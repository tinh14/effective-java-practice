package chapter9.item61;

import java.util.Comparator;

public class Comparators {

    static void print(int result) {
        String str = "";
        switch(result) {
            case -1 -> str = "a is less than b";
            case 0 -> str = "a is equal to b";
            case 1 -> str = "a is greater than b";
        }

        System.out.println(str);
    }

    public static void main(String[] args) {
        Integer i1 = new Integer(42);
        Integer i2 = new Integer(42);

        Comparator<Integer> brokenNaturalOrder =
                (a, b) -> a == b ? 0 : ((a < b) ? -1 : 1);
        print(brokenNaturalOrder.compare(i1, i2));

        Comparator<Integer> fixedNaturalOrder = (a, b) -> {
            int valueA = a, valueB = b;
            return valueA == valueB ? 0 : ((valueA < valueB) ? -1 : 1);
        };
        print(fixedNaturalOrder.compare(i1, i2));

        Comparator<Integer> bestNaturalOrder = Comparator.naturalOrder();
        print(bestNaturalOrder.compare(i1, i2));
    }
}
