package chapter3.item13.staticfactory;

import java.util.ArrayList;
import java.util.List;

public class Yum {
    private String name;
    private List<String> ingredients; // mutable field

    public Yum(String name, List<String> ingredients) {
        this.name = name;
        this.ingredients = new ArrayList<>(ingredients);
    }

    public static Yum copyOf(Yum other) {
        return new Yum(other.name, other.ingredients);
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return String.format("Yum(name=%s, ingredients=%s)", name, ingredients);
    }
}