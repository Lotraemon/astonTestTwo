public class Test {
    public static void main(String[] args) {

        Cat[] catsArray = new Cat[8];
        catsArray[0] = new Cat("Барсик");
        catsArray[1] = new Cat("Пушок");
        catsArray[2] = new Cat("Беляк");
        catsArray[3] = new Cat("Кусок");
        catsArray[4] = new Cat("Рыжик");
        catsArray[5] = new Cat("Клоп");
        catsArray[6] = new Cat("Пуля");
        catsArray[7] = new Cat("Штык");

        Dog dog1 = new Dog("Боб");

        System.out.println("Кол-во котов : " + Animal.getCatCount());
        System.out.println("Кол-во собак : " + Animal.getDogCount());
        System.out.println("Всего животных: " + Animal.getAnimalCount());
        catsArray[0].run(100);
        catsArray[1].run(250);
        dog1.run(300);
        dog1.swim(5);


        Cat.FoodBowl.addFeed(30);  // Наполнить миску
        for (Cat cat : catsArray) {
            cat.eat();
            cat.isFullness();
        }
    }
}
