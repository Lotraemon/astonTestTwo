package Task_2;

public class Contact {
    private String surname;
    private long phoneNumber;

    public Contact(String surname, long phoneNumber) {
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return surname + " : " + phoneNumber;
    }
}
