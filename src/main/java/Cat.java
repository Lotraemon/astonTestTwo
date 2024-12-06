import java.util.Random;

public class Cat extends Animal {

    private boolean fullness;
    FoodBowl foodBowl = new FoodBowl();
    Random random = new Random();
    private int hunger = random.nextInt(10) + 1;

    public Cat(String name) {
        super(name);
        Animal.setCatCount(getCatCount() + 1);
        Animal.setAnimalCount(getAnimalCount() + 1);
    }

    public static class FoodBowl {
        private static int food;

        public int getFood() {
            return food;
        }

        public void setFood(int food) {
            FoodBowl.food = food;
        }

        public static void addFeed(int count) {
            food += count;
            System.out.println("Миска наполнена на: " + count);
        }

        public void cleanFoodBowl() {
            food = 0;
            System.out.println("Миска очищена");
        }
    }

    public void isFullness() {
        if (fullness) {
            System.out.println("   " + getName() + " наелся");
        } else System.out.println("   " + getName() + " голоден");
    }

    public void run(int distance) {
        if (distance > 200) {
            System.out.println("Кот не может пробежать больше 200 метров");
        } else {
            System.out.println(getName() + " пробежал " + distance + " метров");
        }
    }

    public void swim(int distance) {
        System.out.println("Кот не умеет плавать");
    }

    public void eat() {
        if (foodBowl.getFood() - hunger < 0) {
            System.out.print("\nВ миске не хватает еды. " + getName() + " хотел съесть: " + hunger);
        } else {
            foodBowl.setFood(foodBowl.getFood() - hunger);
            fullness = true;
            System.out.print("\n" + getName() + " съел еды: " + hunger + ", в миске осталось: " + foodBowl.getFood());
        }
    }
}
