
public class Park {

    public static class Attractions {
        private String name;
        private int timeWork;
        private int cost;

        public Attractions(String name, int timeWork, int cost) {
            this.name = name;
            this.timeWork = timeWork;
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getTimeWork() {
            return timeWork;
        }

        public void setTimeWork(int timeWork) {
            this.timeWork = timeWork;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }
    }
}
