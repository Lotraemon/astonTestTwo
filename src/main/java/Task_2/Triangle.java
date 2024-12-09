package Task_2;

public class Triangle implements Calculation {

    private final double side1;
    private final double side2;
    private final double side3;
    private final String borderColor;
    private final String backgroundColor;

    public Triangle(double side1, double side2, double side3, String borderColor, String backgroundColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    public double calculateArea() {
        double pp = calculatePerimeter(side1, side2, side3) / 2;
        return Math.sqrt(pp * (pp - side1) * (pp - side2) * (pp - side3));
    }

    public void showInfo() {
        System.out.println("\nТреугольник: ");
        createInfo(borderColor, backgroundColor, side1, side2, side3);
    }
}
