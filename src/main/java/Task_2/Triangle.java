package Task_2;

public class Triangle implements Calculation{

    private int side1;
    private int side2;
    private int side3;
    private String borderColor;
    private String backgroundColor;

    public Triangle(int side1, int side2, int side3, String borderColor, String backgroundColor) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
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
