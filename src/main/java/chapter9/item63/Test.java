package chapter9.item63;

public class Test {

    private static String billingStatement(int numItems) {
        StringBuilder builder = new StringBuilder(numItems * 80);
        for (int i = 0; i < numItems; i++)
            builder.append("Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula.");
        return builder.toString();
    }

    // Broken string concatenation
    private static String billingStatement2(int numItems) {
        String result = "";
        for (int i = 0; i < numItems; i++)
            result += "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula.";
        return result;
    }

    public static void main(String[] args) {
        billingStatement(20_000);
        System.out.println("Finish billing statement 1");

        billingStatement2(20_000);
        System.out.println("Finish billing statement 2");
    }

}
