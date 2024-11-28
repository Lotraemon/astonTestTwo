
public class Test {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "qwer@gmail.com",
                8945346, 15000, 20);
        empArray[1] = new Employee("Petrov Petr", "Trainee", "qwe@gmail.com",
                8945098, 5000, 21);
        empArray[2] = new Employee("Sidorov Sidr", "Engineer", "qw@gmail.com",
                8945346, 15000, 20);
        empArray[3] = new Employee("Gref Herman", "Director", "q@gmail.com",
                8945346, 500000, 50);
        empArray[4] = new Employee("Gosling Ryan", "Courier", "gosling@gmail.com",
                8945346, 0, 33);

        empArray[0].getInfo();

    }
}
