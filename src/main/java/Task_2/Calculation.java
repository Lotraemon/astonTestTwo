package Task_2;

public interface Calculation {

    double calculateArea();

    default double calculatePerimeter(double... sides) {
        double perimeter = 0;
        for (double side : sides) {
            perimeter += side;
        }
        return perimeter;
    }

    default double calculatePerimeter(Circle circle) {
        return 2 * Math.PI * circle.getRadius();
    }

    default void createInfo(String borderColor, String backgroundColor, double... sides) {
        System.out.println("Периметр: " + calculatePerimeter(sides));
        System.out.println("Площадь: " + calculateArea());
        System.out.println("Цвет фона: " + backgroundColor);
        System.out.println("Цвет границ: " + borderColor);
    }
}
