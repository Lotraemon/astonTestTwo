package Task_1;

public class Animal {

    private String name;
    private static int catCount;
    private static int dogCount;
    private static int animalCount;

    public Animal(String name) {
        this.name = name;
    }

    public static void setCatCount(int catCount) {
        Animal.catCount = catCount;
    }

    public static int getDogCount() {
        return dogCount;
    }

    public static void setDogCount(int dogCount) {
        Animal.dogCount = dogCount;
    }

    public static int getCatCount() {
        return catCount;
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCount() {
        return animalCount;
    }

    public static void setAnimalCount(int animalCount) {
        Animal.animalCount = animalCount;
    }

    public void run(int distance) {
        System.out.println(name + " пробежал " + distance + " метров");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыл " + distance + " метров");
    }
}