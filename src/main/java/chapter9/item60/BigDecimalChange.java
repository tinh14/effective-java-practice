package chapter9.item60;

import java.math.BigDecimal;

public class BigDecimalChange {
    public static void main(String[] args) {
        final BigDecimal TEN_CENTS = new BigDecimal(".10");
        BigDecimal fundsInDollars = new BigDecimal("1.00");
        int itemsBought = 0;

        for (BigDecimal priceInDollars = TEN_CENTS;
             fundsInDollars.compareTo(priceInDollars) >= 0;
             priceInDollars = priceInDollars.add(TEN_CENTS)) {
            fundsInDollars = fundsInDollars.subtract(priceInDollars);
            itemsBought++;
        }

        System.out.println(itemsBought + " items bought.");
        System.out.println("Change: $" + fundsInDollars);
    }
}
