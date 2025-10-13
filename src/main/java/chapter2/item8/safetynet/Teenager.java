package chapter2.item8.safetynet;

public class Teenager {
    public static void main(String[] args) throws Exception {
        new Room(99);
        System.out.println("Goodbye, World!");

        System.gc();
        Thread.sleep(1000);
    }
}
