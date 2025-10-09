package chapter2.item2.hierarchicalbuilderv2;

import chapter2.item2.hierarchicalbuilder.CalzonePizza;
import chapter2.item2.hierarchicalbuilder.NewYorkPizza;
import chapter2.item2.hierarchicalbuilder.Pizza;
import chapter2.item2.hierarchicalbuilder.PizzaV2;

public class Order {
    public static void main(String[] args) {

        NewYorkPizza newYorkPizza = new NewYorkPizza.Builder(NewYorkPizza.Size.SMALL)
                .addTopping(Pizza.Topping.SAUSAGE)
                .addTopping(Pizza.Topping.ONION)
                .build();

        CalzonePizza calzonePizza = new CalzonePizza.Builder()
                .addTopping(Pizza.Topping.HAM)
                .sauceInside()
                .build();

        ChicagoPizza chicagoPizza = new ChicagoPizza.Builder()
                .addTopping(PizzaV2.Topping.MUSHROOM)
                .diameter(13)
                .build();

        System.out.println(newYorkPizza);
        System.out.println(calzonePizza);
        System.out.println(chicagoPizza);
    }
}

