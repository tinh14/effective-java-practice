package chapter11.item83;

public class StandardNormalIdiom {
    private final FieldType field = computeFieldValue();

    private static FieldType computeFieldValue() {
        return new FieldType();
    }

    public FieldType getField() {
        return field;
    }

    public static void main(String[] args) {
        StandardNormalIdiom o = new StandardNormalIdiom();
        System.out.println(o.getField());
    }
}
