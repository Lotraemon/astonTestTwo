public class Employee {
    String fullName;
    String position;
    String email;
    int phoneNumber;
    int salary;
    int age;

    public Employee(String fullName, String position, String email, int phoneNumber, int salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    public void getInfo() {
        System.out.println("ФИО: " + fullName + "\nДолжность: " + position + "\nПочта: " + email + "\nТелефон: " +
                +phoneNumber + "\nЗаработная плата: " + salary + "\nВозраст: " + age);
    }
}
