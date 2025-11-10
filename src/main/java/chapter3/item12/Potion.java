package chapter3.item12;


public class Potion {
    private String name;
    private int potency;
    private boolean isRare;

    public Potion(String name, int potency, boolean isRare) {
        this.name = name;
        this.potency = potency;
        this.isRare = isRare;
    }

    public String getName() {
        return name;
    }

    public int getPotency() {
        return potency;
    }

    public boolean isRare() {
        return isRare;
    }

    // lombok toString method simulator
    @Override
    public String toString() {
        return String.format("Potion(name=%s, potency=%d, isRare=%b)", name, potency, isRare);
    }
}
