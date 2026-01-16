package chapter12.item89.broken;

import java.io.Serial;
import java.io.Serializable;

public class Elvis implements Serializable {
    @Serial
    private static final long serialVersionUID = 0;

    public static final Elvis INSTANCE = new Elvis();
    private String favoriteGuitar = "Gibson J-200";

    public void printFavorite() {
        System.out.println(favoriteGuitar);
    }

    public String favoriteGuitar() {
        return favoriteGuitar;
    }

    @Serial
    private Object readResolve() {
        return INSTANCE;
    }
}
