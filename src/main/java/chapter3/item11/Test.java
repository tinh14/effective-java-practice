package chapter3.item11;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Test {
    public static void main(String[] args) {

        // Autoboxing check
        String a = "asd";
        int b = 3;
        long c = 400000000;
        double d = 2.15;
        float e = 3.14f;
        boolean f = false;

        System.out.println("Autoboxing test");
        System.out.println("String:" + a.hashCode() + "-" + Objects.hashCode(a));
        System.out.println("Integer: " + Integer.hashCode(b) + Objects.hashCode(b));
        System.out.println("Long:" + Long.hashCode(c) + "-" + Objects.hashCode(c));
        System.out.println("Double: " + Double.hashCode(d) + "-" + Objects.hashCode(d));
        System.out.println("Float:" + Float.hashCode(e) + "-" + Objects.hashCode(e));
        System.out.println("Boolean: " + Boolean.hashCode(f) + "-" + Objects.hashCode(f));

        System.out.println("\nPhoneNumber test");
        Map<PhoneNumber, String> m = new HashMap<>();
        m.put(new PhoneNumberWithNoHashCode(707, 867, 5309), "Jenny");
        m.put(new PhoneNumberWithHashCode(707, 867, 5309), "Jenny");

        System.out.println("PhoneNumber without overriding hashCode method: "
                + m.get(new PhoneNumberWithNoHashCode(707, 867, 5309)));
        System.out.println("PhoneNumber with overriding hashCode method: "
                + m.get(new PhoneNumberWithHashCode(707, 867, 5309)));
    }
}
