package chapter4.item23.taggedclass;

public class Test {
    public static void main(String[] args) {
        Figure circle = new Figure(10);
        Figure rectangle = new Figure(10, 10);

        System.out.println(circle.area());
        System.out.println(rectangle.area());
    }
}
