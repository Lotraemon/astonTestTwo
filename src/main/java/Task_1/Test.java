package Task_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

    public static void main(String[] args) {
        String[] array = new String[]{"Тест", "Массив", "Список", "Слово", "Раз", "Счет", "Коллекция", "Тест",
                "Тест", "Массив", "Дубликат", "Кот", "Крот", "Пес", "Нож"};
        checkArray(array);
    }

    public static void checkArray(String[] s) {
        Set<String> uniqueWords = new HashSet<>();
        Map<String, Integer> countWords = new HashMap<>();
        for (String s1 : s) {
            uniqueWords.add(s1);
            if (countWords.containsKey(s1)) {
                countWords.put(s1, countWords.get(s1) + 1);
            } else {
                countWords.put(s1, 1);
            }
        }
        System.out.println("Список уникальных слов: " + uniqueWords);
        System.out.println("Сколько раз встречается: " + countWords);
    }
}
