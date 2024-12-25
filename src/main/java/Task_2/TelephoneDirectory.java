package Task_2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TelephoneDirectory {
    private Map<String, List<Long>> directory = new HashMap<>();

    public void add(String surname, Long phoneNumber) {
        directory.putIfAbsent(surname, new ArrayList<>());
        directory.get(surname).add(phoneNumber);
    }

    public void get(String surname) {
        if (directory.containsKey(surname)) {
            System.out.println(surname + " : " + directory.get(surname));
        } else {
            System.out.println("Нет записей");
        }
    }
}
