package Task_1;

import java.util.Random;

public class Cat extends Animal {

    private boolean fullness;
    Random random = new Random();
    private int hunger = random.nextInt(10) + 1;

    public Cat(String name) {
        super(name);
        Animal.setCatCount(getCatCount() + 1);
        Animal.setAnimalCount(getAnimalCount() + 1);
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

    public void eat(Bowl bowl) {
        if (bowl.getFood() - hunger < 0) {
            System.out.print("\nВ миске не хватает еды. " + getName() + " хотел съесть: " + hunger);
        } else {
            bowl.setFood(bowl.getFood() - hunger);
            fullness = true;
            System.out.print("\n" + getName() + " съел еды: " + hunger + ", в миске осталось: " + bowl.getFood());
        }
    }
}
