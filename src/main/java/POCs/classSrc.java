package POCs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                };
        for(Employee e:empList){
            System.out.println(e.getName());
        }
    }
}

class Employee{
    private final String name;
    private final LocalDate hireDate;
    private LocalDate rehireDate;
    private double salary;

    public Employee(String name, LocalDate hireDate, double salary){
        this.name=name;
        this.hireDate=hireDate;
        this.salary=salary;
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
