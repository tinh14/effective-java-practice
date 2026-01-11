package chapter11.item83;

public class SynchronizedAccessorIdiom {
    private FieldType field;

    private FieldType computeFieldValue() {
        return new FieldType();
    }

    public synchronized FieldType getField() {
        if (field == null)
            field = computeFieldValue();
        return field;
    }

    public static void main(String[] args) {
        SynchronizedAccessorIdiom o = new SynchronizedAccessorIdiom();
        System.out.println(o.getField());
    }
}
