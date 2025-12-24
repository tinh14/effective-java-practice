package chapter8.item53.colors;

import java.util.List;

public class ColorFactory {

    public static List<String> of(String color) {
        return List.of(color);
    }

    public static List<String> of(String color1, String color2) {
        return List.of(color1, color2);
    }

    public static List<String> of(String color1, String color2, String color3) {
        return List.of(color1, color2, color3);
    }

    public static List<String> of(String... colors) {
        return List.of(colors);
    }

    public static void main(String[] args) {
        of("Red");
        of("Red", "Green");
        of("Red", "Green", "Blue");
        of("Red", "Green", "Blue", "Yellow");
    }
}
