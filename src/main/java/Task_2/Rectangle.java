package Task_2;

public class Rectangle implements Calculation {

    private final double length;
    private final double width;
    private final String borderColor;
    private final String backgroundColor;

    public Rectangle(int length, int width, String borderColor, String backgroundColor) {
        this.length = length;
        this.width = width;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    public void showInfo() {
        System.out.println("\nПрямоугольник: ");
        createInfo(borderColor, backgroundColor, length, width);
    }
}
