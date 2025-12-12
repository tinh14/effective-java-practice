package chapter6.item39.repeatable;

import java.util.ArrayList;
import java.util.List;

public class Sample {
    @ExceptionTest(NullPointerException.class)
    @ExceptionTest(IndexOutOfBoundsException.class)
    public static void doublyBad() {   // Should pass
        List<String> list = new ArrayList<>();
        list.addAll(5, null);
    }

    @ExceptionTest(NullPointerException.class)
    @ExceptionTest(IndexOutOfBoundsException.class)
    public static void doublyWell() {   // Should fail
        List<String> list = new ArrayList<>();
        list.addAll(0, List.of("ok"));
    }
}
