package chapter11.item83;

public class HolderClassIdiom {

    public static FieldType getField() {
        return FieldHolder.FIELD;
    }

    private static class FieldHolder {
        static final FieldType FIELD = computeFieldValue();

        private static FieldType computeFieldValue() {
            return new FieldType();
        }
    }

    public static void main(String[] args) {
        System.out.println(HolderClassIdiom.getField());
    }
}
