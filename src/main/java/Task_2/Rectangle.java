package Task_2;

public class Rectangle implements Calculation{

    private int length;
    public int width;
    private String borderColor;
    private String backgroundColor;

    public Rectangle(int length, int width, String borderColor, String backgroundColor) {
        this.length = length;
        this.width = width;
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
