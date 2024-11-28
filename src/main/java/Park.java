
public class Park {

    Attractions a1 = new Attractions("Test",8,100);

    class Attractions {
        String name;
        int timeWork;
        int cost;

        public Attractions(String name, int timeWork, int cost) {
            this.name = name;
            this.timeWork = timeWork;
            this.cost = cost;
        }
    }
}
