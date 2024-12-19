package Task_2;

import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private List<String> td = new ArrayList<>();

    public void add(String s, Long i){
        td.add(s + " : " + Long.toString(i));
    }
    public void get(String s){
        for (String s1:td){
            if (s1.contains(s)) {
                System.out.println(s1);
            }
        }
    }
}
