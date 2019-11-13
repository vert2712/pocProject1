package POCs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.System.out;

/**
 * A {@code}Employee is used to describe Employee
 * @author PaulReed
 */
class Employee{
    private final String name;
    private final LocalDate hireDate;
    private LocalDate rehireDate;
    private double salary;
    private static int counter;
    private int id;

    //instance init block executed prior to constructor
    {
        out.println("Inside instance init block");
    }

    //static init block
    static{
        out.println("Inside Employee static init block");
        counter=getDefaultCounter();
    }

    private int setID(){
        System.out.println("ID field was set");
        return Employee.counter++;
    }

    /**
     *
     * @return value description here
     */
    private static int getDefaultCounter(){
        return 0;
    }

    public Employee(String name, LocalDate hireDate, double salary){
        System.out.println("Employee parametrized constructor was called");
        this.name=name;
        this.hireDate=hireDate;
        this.salary=salary;
        this.id = setID();
    }

    public static int getCounter(){
        return counter;
    }

    public static Employee createAdvancedEmployee(){
        return new Employee(
                "Advanced Employee", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 3000
        );
    }

    public static Employee createStarterEmployee(){
        return new Employee(
                "Starter Employee", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1000
        );
    }

    public String getName(){
        return this.name;
    }

    public LocalDate getHireDate(){
        return this.hireDate;
    }

    public double getSalary(){
        return this.salary;
    }

    /**
     *
     * @param perc description here
     */
    public void raiseSalary(double perc){
        double raise=this.salary*perc/100;
        this.salary+=raise;
    }
}