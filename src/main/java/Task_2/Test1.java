package Task_2;

public class Test1 {
    public static void main(String[] args) {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", 89796568768l);
        td.add("Петров", 8973453456l);
        td.add("Петрович", 897345345l);
        td.add("Петровский", 89734756l);
        td.add("Сидоров", 89797657l);
        td.add("Владимиров", 83333356l);
        td.add("Генадьев", 82222222l);
        td.add("Андреев", 8979656l);
        td.add("Иванов", 80000000l);
        td.add("Иванов", 81111111l);

        td.get("Иванов");
        td.get("Петров");
    }
}
