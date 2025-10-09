package chapter2.item2.hierarchicalbuilder;

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

        System.out.println(newYorkPizza);
        System.out.println(calzonePizza);
    }
}
