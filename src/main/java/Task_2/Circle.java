package Task_2;

public class Circle implements Calculation{

    private int radius;
    private String borderColor;
    private String backgroundColor;

    public Circle(int radius, String borderColor, String backgroundColor) {
        this.radius = radius;
        this.borderColor = borderColor;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public void calculatePerimeter() {

    }

    @Override
    public void calculateArea() {

    }
}
