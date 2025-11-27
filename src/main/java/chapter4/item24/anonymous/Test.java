package chapter4.item24.anonymous;

public class Test {
    public static void main(String[] args) {
        // Anonymous class
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Anonymous class");
            }
        };

        // Lambda expression
        Runnable r2 = () -> System.out.println("lambda expression");

        r1.run();
        r2.run();
    }
}
