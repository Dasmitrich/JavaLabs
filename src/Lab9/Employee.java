package Lab9;

import java.time.LocalDate;

public class Employee {
    private String name, surname, place;
    private LocalDate birthdayDate;

    public Employee(){}
    public Employee(String name, String surname, String place, LocalDate birthdayDate) {
        this.name = name;
        this.surname = surname;
        this.place = place;
        this.birthdayDate = birthdayDate;
    }
}
