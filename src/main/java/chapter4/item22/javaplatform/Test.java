package chapter4.item22.javaplatform;

import javax.swing.*;
import java.io.ObjectStreamConstants;

public class Test {
    public static void main(String[] args) {
        // Some Java platform interfaces violated this rule (Don't use interfaces as enum definition).
        // This approach was accepted in the early days of Java because enums were not yet available.
        // Today, this approach is considered a bad idea.
        System.out.println(ObjectStreamConstants.STREAM_MAGIC);
        System.out.println(WindowConstants.EXIT_ON_CLOSE);
    }
}
