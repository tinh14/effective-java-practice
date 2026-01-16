package chapter12.item89.best;

public enum Elvis {
    INSTANCE;

    private String favoriteGuitar = "Gibson J-200";

    public String favoriteGuitar() {
        return favoriteGuitar;
    }

    public void printFavorite() {
        System.out.println(favoriteGuitar);
    }
}
