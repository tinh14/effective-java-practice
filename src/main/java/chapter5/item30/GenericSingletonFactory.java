package chapter5.item30;

import java.util.function.UnaryOperator;

public class GenericSingletonFactory {

    private static final UnaryOperator<?> IDENTITY_FN = (t) -> t;

    @SuppressWarnings("unchecked")
    public static <T> UnaryOperator<T> identityFunction() {
        return (UnaryOperator<T>) IDENTITY_FN;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        UnaryOperator<Integer> sameInt = identityFunction();
        for (Integer i : intArr) {
            System.out.print(sameInt.apply(i));
        }

        String[] stringArr = {"a", "b", "c"};
        UnaryOperator<String> sameStr = identityFunction();
        for (String s : stringArr) {
            System.out.print(sameStr.apply(s));
        }
    }
}
