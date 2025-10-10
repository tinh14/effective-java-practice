package chapter2.item3.serializable;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ElvisV2 implements Serializable {

//    transient is unnecessary because static fields are not serialized
    @Serial
    private static final transient long serialVersionUID = 1L;

    private static final transient Logger logger = Logger.getLogger(ElvisV2.class.getName());

    public static final transient ElvisV2 INSTANCE = new ElvisV2();

    private ElvisV2() {
    }

//     Ensure that deserialization returns the same instance
    @Serial
    private Object readResolve() {
        return INSTANCE;
    }

//      Misspelled method name
//    @Serial
//    private Object readResolvee() {
//        return INSTANCE;
//    }

    public void leaveTheBuilding() {
        System.out.println("[Elvis] Whoa baby, I'm outta here!");
    }

    public static void main(String[] args) {
        ElvisV2 elvis = ElvisV2.INSTANCE;
        elvis.leaveTheBuilding();

        String fileName = "elvis.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))){
            out.writeObject(elvis);
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Serialization error", e);
        }

        ElvisV2 elvis2 = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            elvis2 = (ElvisV2) in.readObject();
            elvis2.leaveTheBuilding();
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Deserialization error", e);
        }

        System.out.println(elvis == elvis2 ? "Same instance" : "Different instance");
    }
}