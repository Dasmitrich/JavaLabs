package lab9;

import java.time.LocalDate;

public class Employee {
    private String name, surname, place, position;
    private LocalDate birthdayDate;
    public int salary;

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }

    public int getSalary() {
        return salary;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Employee(){}
    public Employee(String name, String surname, String place, LocalDate birthdayDate) {
        this.name = name;
        this.surname = surname;
        this.place = place;
        this.birthdayDate = birthdayDate;
    }
}
