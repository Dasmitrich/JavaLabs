package lab9;

import java.time.LocalDate;
import java.util.ArrayList;

public class Company implements lab9.Job {
public int salary;
public String position;

    public int getSalary() {
        return salary;
    }

    public void switchPosition(){

    }

    public void hire(String pos, lab9.Employee employee) {
        switch (pos) {
            case "Engineer":
        employee.setPosition("Engineer");
                break;
            case "Programmer":
        employee.setPosition("Programmer");
                break;
            case "Philosopher":
        employee.setPosition("Philosopher");
                break;
        }
    }

    public void fire(lab9.Employee c) {
        c = null;
    }


    @Override
    public void HandleEmployees(lab9.Employee employee, int salary) {
    employee.setSalary(salary);
    }
}

class Run{
    public static void main(String[] args) {

        ArrayList<lab9.Employee> employees = new ArrayList<>();
        //ArrayList<Company> com = new ArrayList<>();

        employees.add(0, new lab9.Employee( "John", "Jacobson" , "Arizona", LocalDate.of(1990, 12, 3)));
        employees.add(1, new lab9.Employee("Nick", "Dilan", "Jamaica", LocalDate.of(2000, 1, 29)));
        employees.add(2, new lab9.Employee("Serg", "Kirhmann", "Jerusalem", LocalDate.of(1983, 5, 11)));

        Company com = new Company();
        com.hire("Engineer", employees.get(0));
        com.hire("Programmer", employees.get(1));
        com.hire("Philosopher", employees.get(2));

        com.HandleEmployees(employees.get(0), 5000);
        System.out.println(employees.get(0).getName() + " " + employees.get(0).getSalary());


        lab9.Job job = (employee, i) -> {    //lambda-expression
            employee.setSalary(i);
            employee.setPosition("Cleaner");
            System.out.println(employees.get(1).getName() + " " + employee.getSalary());
        };
        job.HandleEmployees(employees.get(1), 500);


        lab9.Job job1 = new lab9.Job() { //anonymous class
            @Override
            public void HandleEmployees(lab9.Employee employee, int i) {
                employee.setPlace("New-Deli");
                System.out.println(employees.get(2).getName() + " " + employee.getPlace());
            }
        };
        job1.HandleEmployees(employees.get(2), 0);

    }
}