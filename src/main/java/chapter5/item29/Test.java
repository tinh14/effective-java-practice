package chapter5.item29;

public class Test {
    public static void main(String[] args) {
        NiceStack<String> niceStack = new NiceStack<>();
        niceStack.push("hello");
        niceStack.push("world");
        while (!niceStack.isEmpty()) {
            System.out.print(niceStack.pop().toUpperCase() + " ");
        }

        System.out.println();

        NicerStack<String> nicerStack = new NicerStack<>();
        nicerStack.push("hello");
        nicerStack.push("world");
        while (!nicerStack.isEmpty()) {
            System.out.print(nicerStack.pop().toUpperCase() + " ");
        }
    }
}
