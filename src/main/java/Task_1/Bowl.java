package Task_1;

public class Bowl {
    private int food;

    public Bowl(int food) {
        this.food = food;
        System.out.println("\nСоздана миска с кол-вом еды: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public void addFood(int count) {
        food += count;
        System.out.println("\nМиска наполнена на: " + count);
    }

    public void cleanFoodBowl() {
        food = 0;
        System.out.println("Миска очищена");
    }
}
