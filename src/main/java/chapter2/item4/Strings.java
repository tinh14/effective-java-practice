package chapter2.item4;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class Strings {

    private Strings() {
        throw new AssertionError("Cannot instantiate Utility class");
    }

    public static String capitalize(String word) {
        if (word == null || word.isEmpty()) {
            return word;
        }
        return Character.toUpperCase(word.charAt(0)) + word.substring(1);
    }

    public static void main(String[] args) throws Exception {
        System.out.println(Strings.capitalize("Hello"));
        System.out.println(Strings.capitalize("world"));

        Constructor<Strings> constructor = Strings.class.getDeclaredConstructor();
        constructor.newInstance();
    }

}
