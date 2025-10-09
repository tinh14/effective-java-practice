package chapter2.item2.freezablejavabeans;

public class NutritionFacts {
    private int servingSize = -1;
    private int servings = -1;
    private int calories = 0;
    private int fat = 0;
    private int sodium = 0;
    private int carbohydrate = 0;

    private boolean frozen = false;

    // Parameterless constructor
    // Call this to create an object and then use setters to set values
    public NutritionFacts(){
    }

    public void setServingSize(int servingSize) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.servingSize = servingSize;
    }

    public void setServings(int servings) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.servings = servings;
    }

    public void setCalories(int calories) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.calories = calories;
    }

    public void setFat(int fat) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.fat = fat;
    }

    public void setSodium(int sodium) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.sodium = sodium;
    }

    public void setCarbohydrate(int carbohydrate) {
        if (isFrozen()) {
            throw new IllegalStateException("Object is frozen and cannot be modified");
        }
        this.carbohydrate = carbohydrate;
    }

    public void freeze() {
        this.frozen = true;
    }

    public boolean isFrozen() {
        return frozen;
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
                ", frozen=" + frozen +
                '}';
    }

    public static void main(String[] args) {

        NutritionFacts cocaCola = new NutritionFacts();

        System.out.println(cocaCola);

        cocaCola.setServingSize(240);
        cocaCola.setServings(8);
        cocaCola.setCalories(100);
        cocaCola.setSodium(35);
        cocaCola.setCarbohydrate(27);

        cocaCola.freeze();

        System.out.println(cocaCola);

        cocaCola.setFat(36);
    }
}

