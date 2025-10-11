package chapter2.item6.string;


import java.util.Objects;

public class Test {
    public static void main(String[] args) throws Exception {
        String a = "a";
        String b = "b";
        String c = "a";
        String d = new String("a");
        String e = String.valueOf("a");

        System.out.println("a equals b: " + (a ==b));
        System.out.println("a equals c: " + (a == c));
        System.out.println("a equals d: " + (a == d));
        System.out.println("a equals e: " + (a == e));

        System.out.println("Hash code of a: " + Objects.hashCode(a));
        System.out.println("Hash code of b: " + Objects.hashCode(b));
        System.out.println("Hash code of c: " + Objects.hashCode(c));
        System.out.println("Hash code of d: " + Objects.hashCode(d));
        System.out.println("Hash code of e: " + Objects.hashCode(e));
    }
}
