package chapter8.item52.overriding;

import java.util.List;

public class DogTrainer {

    private static void rollCall(Dog dog) {
        System.out.println(dog.name());
    }

    public static void main(String[] args) {

        List<Dog> dogs = List.of(new Dog(), new Chihuahua(), new Bulldog());

        for (Dog dog : dogs) {
            rollCall(dog);
        }
    }
}
