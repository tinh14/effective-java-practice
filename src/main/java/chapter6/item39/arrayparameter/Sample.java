package chapter6.item39.arrayparameter;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @ExceptionTest(values = {IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyBad() {   // Should pass
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

    @ExceptionTest(values = {IndexOutOfBoundsException.class, NullPointerException.class})
    public static void doublyWell() {   // Should fail
        List<String> list = new ArrayList<>();
        list.addAll(0, List.of("ok"));
    }
}
