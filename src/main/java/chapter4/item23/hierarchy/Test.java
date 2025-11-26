package chapter4.item23.hierarchy;

public class Test {
    public static void main(String[] args) {
        Figure circle = new Circle(10);
        Figure rectangle = new Rectangle(10, 10);
        Figure square = new Square(20);

        System.out.println(circle.area());
        System.out.println(rectangle.area());
        System.out.println(square.area());
    }
}
