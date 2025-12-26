package chapter9.item60;

public class IntChange {
    public static void main(String[] args) {
        int fundsInCents = 100;
        int itemsBought = 0;

        for (int priceInCents = 10; fundsInCents >= priceInCents; priceInCents += 10) {
            fundsInCents -= priceInCents;
            itemsBought++;
        }

        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + fundsInCents);
    }
}
