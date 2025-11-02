package chapter2.item3.enumeration;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

public enum Elvis {
    INSTANCE;

    private static final transient Logger logger = Logger.getLogger(Elvis.class.getName());

    public void leaveTheBuilding() {
        System.out.println("[Elvis] Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();

        String fileName = "src/main/java/chapter2/item3/serializable/elvis.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(elvis);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Serialization error", e);
        }

        Elvis elvis2 = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            elvis2 = (Elvis) in.readObject();
            elvis2.leaveTheBuilding();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Deserialization error", e);
        }

        System.out.println(elvis == elvis2 ? "Same instance" : "Different instance");
    }
}
