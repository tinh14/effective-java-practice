package chapter11.item83;

public class SingleCheckIdiom {
    private volatile FieldType field;

    private FieldType computeFieldValue() {
        return new FieldType();
    }

    public FieldType getField() {
        FieldType result = field;
        if (result == null)
            field = result = computeFieldValue();
        return result;
    }

    public static void main(String[] args) {
        SingleCheckIdiom o = new SingleCheckIdiom();
        System.out.println(o.getField());
    }
}
