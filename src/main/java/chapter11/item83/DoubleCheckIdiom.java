package chapter11.item83;

public class DoubleCheckIdiom {
    private volatile FieldType field;

    private FieldType computeFieldValue() {
        return new FieldType();
    }

    public FieldType getField() {
        FieldType result = field; // Avoids accessing to volatile field for better performance
        if (result == null) {
            synchronized (this) {
                if (field == null)
                    field = result = computeFieldValue();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        DoubleCheckIdiom o = new DoubleCheckIdiom();
        System.out.println(o.getField());
    }
}
