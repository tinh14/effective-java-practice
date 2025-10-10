package chapter2.item3.field;

public class ElvisV2 {
    public static final ElvisV2 INSTANCE = new ElvisV2();

    private ElvisV2() {
        if (INSTANCE != null) {
            throw new AssertionError("Cannot instantiate ElvisV2");
        }
    }

    public void leaveTheBuilding() {
        System.out.println("[ElvisV2] Whoa baby, I'm outta here!");
    }
}

