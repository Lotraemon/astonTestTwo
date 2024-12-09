package Task_2;

public class Circle implements Calculation {

    private final double radius;
    private final String borderColor;
    private final String backgroundColor;

    public Circle(double radius, String borderColor, String backgroundColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    public void showInfo() {
        System.out.println("\nКруг: ");
        createInfo(borderColor, backgroundColor, calculatePerimeter(this));
    }
}
