public class Animal {

    String name;
    private int catCount;
    int dogCount;

    public Animal(String name) {
        this.name = name;
    }

    public int getCatCount() {
        return catCount;
    }

    public void run(int distance){
        System.out.println(name + " пробежал " + distance + " метров");
    }
    public void swim(int distance){
        System.out.println(name + " проплыл " + distance + " метров");
    }
}
