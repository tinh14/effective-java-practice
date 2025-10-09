package chapter2.item2.hierarchicalbuilder;

import java.util.EnumSet;
import java.util.Set;

public abstract class PizzaV2 {

    public enum Topping { HAM, MUSHROOM, ONION, PEPPER, SAUSAGE }

    protected final Set<Topping> toppings;

    protected abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        protected abstract PizzaV2 build();

        protected abstract T self();
    }

    protected PizzaV2(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }
}
