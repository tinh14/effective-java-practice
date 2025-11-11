package chapter3.item13.staticfactory;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> ing = new ArrayList<>();
        ing.add("Sugar");
        ing.add("Milk");

        Yum original = new Yum("Cake", ing);

        // Copies through static factory method.
        Yum copy = Yum.copyOf(original);

        // Modifies original yum's mutable object.
        original.getIngredients().add("Eggs");

        System.out.println(original);
        System.out.println(copy);
    }
}
