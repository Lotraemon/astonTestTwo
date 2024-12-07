package Task_2;

public interface Calculation {
    public void calculatePerimeter();

    public void calculateArea();

    public default void showInfo(String borderColor, String backgroundColor){

    }
}
