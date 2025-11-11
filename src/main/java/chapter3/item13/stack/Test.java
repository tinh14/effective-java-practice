package chapter3.item13.stack;

public class Test {

    public static void main(String[] args) {
        DumbStack dumbStack = new DumbStack();
        dumbStack.push(1);
        dumbStack.push(2);
        dumbStack.push(3);

        SmartStack smartStack = new SmartStack();
        smartStack.push(1);
        smartStack.push(2);
        smartStack.push(3);

        DumbStack dumpStackCopy = dumbStack.clone();
        SmartStack smartStackCopy = smartStack.clone();

        System.out.println("DUMB STACK");
        System.out.print("original stack: ");
        while (!dumbStack.isEmpty())
            System.out.print(dumbStack.pop() + " ");
        System.out.print("\ncopy stack: ");
        while (!dumpStackCopy.isEmpty())
            System.out.print(dumpStackCopy.pop() + " ");

        System.out.println("\nSMART STACK");
        System.out.print("original stack: ");
        while (!smartStack.isEmpty())
            System.out.print(smartStack.pop() + " ");
        System.out.print("\ncopy stack: ");
        while (!smartStackCopy.isEmpty())
            System.out.print(smartStackCopy.pop() + " ");
    }
}
