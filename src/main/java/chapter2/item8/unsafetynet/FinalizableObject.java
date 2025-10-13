package chapter2.item8.unsafetynet;

import java.util.ArrayList;
import java.util.List;

public class FinalizableObject {

    private int index;
    private byte[] data = new byte[10 * 1024 * 1024]; // 10MB

    public FinalizableObject(int index) {
        this.index = index;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizing object with index: " + index);
        super.finalize();
    }

    public static void main(String[] args) throws InterruptedException {
        List<FinalizableObject> objects = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            objects.add(new FinalizableObject(i+1));
        }
        System.out.println("Check VisualVM now");
        Thread.sleep(10000); // Wait to check VisualVM

        objects.clear();
        objects = null;
        Thread.sleep(200);


//        System.gc();
//        Thread.sleep(500);

//        Finalizers are unpredictable, so we need to call System.gc multiple times to see the effect
        for (int i = 0; i < 10; i++) {
            System.gc(); // Enforce GC to run
            Thread.sleep(500); // wait for GC to run
        }


        System.out.println("Check VisualVM again");
        Thread.sleep(30000); // Wait to check VisualVM again
    }
}
