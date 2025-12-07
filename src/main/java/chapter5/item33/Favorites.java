package chapter5.item33;


import java.util.HashMap;
import java.util.Map;

public class Favorites {
    private final Map<Class<?>, Object> favorites = new HashMap<>();

    public <T> T get(Class<T> type) {
        return type.cast(favorites.get(type));
    }

    public <T> void put1(Class<? extends T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }

    public <T> void put2(Class<T> type, T instance) {
        favorites.put(type, type.cast(instance));
    }

    public static void main(String[] args) {
        Favorites f = new Favorites();
        f.put1(Integer.class, 3.14); // ClassCastException
//        f.put2(Integer.class, 3.14); // Won't compile
    }
}
