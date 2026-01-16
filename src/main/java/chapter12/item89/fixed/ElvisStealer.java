package chapter12.item89.fixed;

import java.io.*;

public class ElvisStealer implements Serializable {
    @Serial
    private static final long serialVersionUID = 0;

    private static Elvis impersonator;
    private Elvis elvisBody;

    @Serial
    private Object readResolve() {
        impersonator = elvisBody;
        return "Ukulele";
    }

    private static byte[] generateSerializedForm() throws Exception {
        Elvis elvis = Elvis.INSTANCE; // Supposes this instance was read from the input stream.
        String favoriteGuitar = elvis.favoriteGuitar();

        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
             ObjectOutputStream os = new ObjectOutputStream(baos) {
                 {
                     enableReplaceObject(true);
                 }

                @Override
                protected Object replaceObject(Object obj) {
                    if (favoriteGuitar.equals(obj)) {
                        ElvisStealer elvisStealer = new ElvisStealer();
                        elvisStealer.elvisBody = elvis;
                        return elvisStealer;
                    }
                    return obj;
                }
             }) {
            os.writeObject(elvis);
            return baos.toByteArray();
        }
    }

    public static void main(String[] args) throws Exception {
        byte[] serializedForm = generateSerializedForm();
        try (ByteArrayInputStream bais = new ByteArrayInputStream(serializedForm);
             ObjectInputStream is = new ObjectInputStream(bais)) {
            Elvis elvis = (Elvis) is.readObject();

            elvis.printFavorite();
            if (ElvisStealer.impersonator != null) {
                ElvisStealer.impersonator.printFavorite();
            }
        }
    }
}
