package chapter11.item83;

public class RacySingleCheckIdiom {
    private int field;

    private int computeFieldValue() {
        return 31;
    }

    public int getField() {
        if (field == 0)
            field = computeFieldValue();
        return field;
    }

    public static void main(String[] args) {
        RacySingleCheckIdiom o = new RacySingleCheckIdiom();
        System.out.println(o.getField());
    }
}
