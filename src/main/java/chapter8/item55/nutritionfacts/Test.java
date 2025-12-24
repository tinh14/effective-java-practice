package chapter8.item55.nutritionfacts;

public class Test {
    public static void main(String[] args) {
        OldNutritionFacts oldCocaCola = new OldNutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        NewNutritionFacts newCocaCola = new NewNutritionFacts.Builder(240, 8)
                .calories(100)
                .sodium(35)
                .carbohydrate(27)
                .build();

        System.out.println("Old: " + oldCocaCola);
        if (oldCocaCola.getCarbohydrate() != 0)
            System.out.println(oldCocaCola.getCarbohydrate());

        System.out.println("New: " + newCocaCola);
        newCocaCola.carbohydrate().ifPresent(System.out::println);
    }
}
