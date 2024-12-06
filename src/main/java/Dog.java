public class Dog extends Animal{

    public Dog(String name) {
        super(name);
        Animal.setDogCount(getDogCount()+1);
        Animal.setAnimalCount(getAnimalCount() + 1);
    }

    public void run(int distance) {
        if (distance > 500) {
            System.out.println("Собака не может пробежать больше 500 метров");
        } else
            System.out.println(getName() + " пробежал " + distance + " метров");
    }

    public void swim(int distance){
        if (distance > 10) {
            System.out.println("Собака не может проплыть больше 10 метров");
        } else
            System.out.println(getName() + " проплыл " + distance + " метров");
    }

}
