package chapter9.item60;

public class Change {
    public static void main(String[] args) {
        double fundsInDollars = 1.00;
        int itemsBought = 0;
        for (double price = 0.10; fundsInDollars >= price; price += 0.10) {
            fundsInDollars -= price;
            itemsBought++;
        }

        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + fundsInDollars);
    }
}

