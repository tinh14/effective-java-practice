package chapter7.item45;

public class CharStream {
    public static void main(String[] args) {
        String s = "Hello World!";

        // There's no stream's API for the character type.
        // chars() method returns a IntStream where each element is an int value.
        s.chars().forEach(System.out::print);

        System.out.println();

        // To fix that problem, we need to cast each int value to a char.
        s.chars().forEach(c -> System.out.print((char) c));
    }
}
