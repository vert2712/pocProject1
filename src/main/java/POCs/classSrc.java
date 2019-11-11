package POCs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class classSrc {
    public static void getDefault(){
        Date d=new Date();
        System.out.println(d);
    }

    public static void getEmployees(){
        Employee[] empList=new Employee[]
                {
                  new Employee("Paul Reed", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                  new Employee("Samuel Gerard", LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 2300),
                  Employee.getNewManager(),
                  Employee.getNewBoss()
                };

        for(Employee e:empList){
            System.out.println(e.getName());
        }
        System.out.println(Employee.getCounter());
    }
}

class Employee{
    private final String name;
    private final LocalDate hireDate;
    private LocalDate rehireDate;
    private double salary;
    private static int counter=0;
    private int id = setID();

    private int setID(){
        System.out.println("ID field was set");
        return Employee.counter++;
    }

    public Employee(String name, LocalDate hireDate, double salary){
        System.out.println("Employee parametrized constructor was called");
        this.name=name;
        this.hireDate=hireDate;
        this.salary=salary;

    }

    public static int getCounter(){
        return counter;
    }

    public static Employee getNewManager(){
        return new Employee(
            "Manager", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 5000
        );
    }
    public static Employee getNewBoss(){
        return new Employee(
            "Boss", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 10000
        );
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getHireDate(){
        return this.hireDate;
    }

    public void raiseSalary(double perc){
        double raise=this.salary*perc/100;
        this.salary+=raise;
    }
}
