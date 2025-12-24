package chapter8.item55.nutritionfacts;

import java.util.OptionalInt;

public class NewNutritionFacts {
    private final int servingSize;
    private final int servings;

    private final OptionalInt calories;
    private final OptionalInt fat;
    private final OptionalInt sodium;
    private final OptionalInt carbohydrate;

    public OptionalInt calories() {
        return calories;
    }

    public OptionalInt fat() {
        return fat;
    }

    public OptionalInt sodium() {
        return sodium;
    }

    public OptionalInt carbohydrate() {
        return carbohydrate;
    }

    public static class Builder {
        private final int servingSize;
        private final int servings;

        private OptionalInt calories = OptionalInt.empty();
        private OptionalInt fat = OptionalInt.empty();
        private OptionalInt sodium  = OptionalInt.empty();
        private OptionalInt carbohydrate  = OptionalInt.empty();

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            this.calories = OptionalInt.of(val);
            return this;
        }

        public Builder fat(int val) {
            this.fat = OptionalInt.of(val);
            return this;
        }

        public Builder sodium(int val) {
            this.sodium = OptionalInt.of(val);
            return this;
        }

        public Builder carbohydrate(int val) {
            this.carbohydrate = OptionalInt.of(val);
            return this;
        }

        public NewNutritionFacts build() {
            return new NewNutritionFacts(this);
        }
    }

    private NewNutritionFacts(Builder builder) {
        this.servingSize = builder.servingSize;
        this.servings = builder.servings;
        this.calories = builder.calories;
        this.fat = builder.fat;
        this.sodium = builder.sodium;
        this.carbohydrate = builder.carbohydrate;
    }

    @Override
    public String toString() {
        return "NutritionFacts{" +
                "servingSize=" + servingSize +
                ", servings=" + servings +
                ", calories=" + calories +
                ", fat=" + fat +
                ", sodium=" + sodium +
                ", carbohydrate=" + carbohydrate +
                '}';
    }
}

