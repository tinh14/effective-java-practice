package chapter2.item3.field;

public class Elvis {
    public static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public void leaveTheBuilding() {
        System.out.println("[Elvis] Whoa baby, I'm outta here!");
    }

}