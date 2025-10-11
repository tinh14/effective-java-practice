package chapter2.item6.bool;


import java.util.Objects;

public class Test {
    public static void main(String[] args) throws Exception {
        Boolean x = true;
        Boolean y = true;
        Boolean z = new Boolean(true);
        Boolean w = Boolean.valueOf(true);
        Boolean v = Boolean.TRUE;

        System.out.println("x equals y: " + (x == y));
        System.out.println("x equals z: " + (x == z));
        System.out.println("x equals w: " + (x == w));
        System.out.println("x equals v: " + (x == v));
        System.out.println("Hash code of x: " + Objects.hashCode(x));
        System.out.println("Hash code of y: " + Objects.hashCode(y));
        System.out.println("Hash code of z: " + Objects.hashCode(z));
        System.out.println("Hash code of w: " + Objects.hashCode(w));
        System.out.println("Hash code of v: " + Objects.hashCode(v));
    }
}
