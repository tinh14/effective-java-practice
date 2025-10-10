package chapter2.item3.staticfactorymethod;

import java.util.function.Supplier;

public class Elvis {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
        System.out.println("[Elvis] Whoa baby, I'm outta here!");
    }


    public static void main(String[] args) {
        Elvis elvis = Elvis.getInstance();
        elvis.leaveTheBuilding();

        // Get instance as a Supplier
        Supplier<Elvis> supplier = Elvis::getInstance;
        Elvis elvis2 = supplier.get();
        elvis2.leaveTheBuilding();

    }
}