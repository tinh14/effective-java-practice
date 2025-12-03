package chapter5.item28;

import java.util.Arrays;
import java.util.List;

public class AnnoyingWarning {

    public AnnoyingWarning() {
    }

    // An array is created to hold varargs parameters.
    // If the element type of this array is non-reifiable, we get a warning.
    // Using @SafeVarargs annotation for suppressing the warning.
    @SafeVarargs
    public static <T> List<T> asList(T...params) {
        return Arrays.asList(params);
    }
}
