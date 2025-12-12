package chapter6.item39.repeatable;

import java.lang.annotation.*;

// Indicates that the annotated method is a test method
// that expects throwing the designated exception
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(ExceptionTestContainer.class)
public @interface ExceptionTest {
    Class<? extends Throwable> value();
}
