package chapter2.item8.safetynet;

public class Adult {
    public static void main(String[] args) throws Exception {
        try (Room room = new Room(7)) {
            System.out.println("Goodbye, World!");
        }
    }
}
