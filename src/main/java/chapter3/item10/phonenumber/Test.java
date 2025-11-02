package chapter3.item10.phonenumber;

public class Test {
    public static void main(String[] args) {
        PhoneNumber pn1 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn2 = new PhoneNumber(123, 456, 7890);
        PhoneNumber pn3 = new PhoneNumber(321, 654, 9870);

        System.out.println("pn1.equals(pn2): " + pn1.equals(pn2)); // true
        System.out.println("pn1.equals(pn3): " + pn1.equals(pn3)); // false
        System.out.println("pn1.equals(null): " + pn1.equals(null)); // false
        System.out.println("pn1.equals(String): " + pn1.equals("test")); // false

        try {
            new PhoneNumber(1000, 123, 4567); // areaCode > 999
            new PhoneNumber(123, -1, 4567); // prefix < 0
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
