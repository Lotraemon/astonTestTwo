package Task_2;

public class Test1 {
    public static void main(String[] args) {
        TelephoneDirectory td = new TelephoneDirectory();
        td.add("Иванов", 89796568768L);
        td.add("Петров", 8973453456L);
        td.add("Петрович", 897345345L);
        td.add("Петровский", 89734756L);
        td.add("Сидоров", 89797657L);
        td.add("Владимиров", 83333356L);
        td.add("Генадьев", 82222222L);
        td.add("Андреев", 8979656L);
        td.add("Иванов", 80000000L);
        td.add("Иванов", 81111111L);

        td.get("Иванов");
        td.get("Петров");
        td.get("xx");
    }
}
