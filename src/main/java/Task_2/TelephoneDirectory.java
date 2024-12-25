package Task_2;

import java.util.ArrayList;
import java.util.List;

public class TelephoneDirectory {
    private List<Contact> directory = new ArrayList<>();

    public void add(String surname, Long phoneNumber) {
        directory.add(new Contact(surname, phoneNumber));
    }

    public void get(String surname) {
        List<Contact> searchResult = new ArrayList<>();
        for (Contact contact : directory) {
            if (surname.equals(contact.getSurname())) {
                searchResult.add(contact);
            }
        }
        System.out.println(searchResult);
    }
}
