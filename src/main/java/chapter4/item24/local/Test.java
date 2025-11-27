package chapter4.item24.local;

public class Test {

    public void instanceMethod() {
        class StupidNestedClass {
            // Only constant variables accepted
            static final int CONSTANT = 100;

            public void localMethod() {
                System.out.println("LOCAL METHOD");
            }
        }

        System.out.println(StupidNestedClass.CONSTANT);

        StupidNestedClass c = new StupidNestedClass();
        c.localMethod();
    }

    public static void classMethod() {
        // same
        class StupidNestedClass {
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.instanceMethod();
    }
}
