package Task_2;

public class Test {
    public static void main(String[] args) {
        Triangle triangle1 = new Triangle(2, 2, 3, "Black", "White");
        Circle circle1 = new Circle(1, "Black", "Blue");
        Rectangle rectangle1 = new Rectangle(4, 6, "Black", "Red");

        triangle1.showInfo();
        circle1.showInfo();
        rectangle1.showInfo();
    }
}
