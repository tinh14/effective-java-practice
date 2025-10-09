package chapter2.item2.hierarchicalbuilderv2;

import chapter2.item2.hierarchicalbuilder.PizzaV2;

public class ChicagoPizza extends PizzaV2 {

    private final int diameter; // inches

    public static class Builder extends PizzaV2.Builder<Builder> {

        private int diameter = 12;

        public Builder diameter(int val) {
            this.diameter = val;
            return this;
        }

        @Override
        public ChicagoPizza build() {
            return new ChicagoPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private ChicagoPizza(Builder builder) {
        super(builder);
        diameter = builder.diameter;
    }

    @Override
    public String toString() {
        return "ChicagoPizza{" +
                "toppings=" + toppings +
                ", diameter=" + diameter +
                '}';
    }
}
