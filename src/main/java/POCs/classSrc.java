package POCs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import static java.lang.System.out;

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
                  Employee.createStarterEmployee(),
                  Employee.createAdvancedEmployee()
                };

        for(Employee e:empList){
            System.out.println(e.getName());
        }
        System.out.println(Employee.getCounter());
    }

    public static void getManagers(){
        Manager[] managerList=new Manager[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Manager("Boss2", LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 2300)
                };

        for(Manager e:managerList){
            System.out.println(e.getSalary());
        }
        System.out.println(Employee.getCounter());
    }

    public static void getMixed(){
        Manager[] managers=new Manager[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Manager("Boss2", LocalDate.parse("2000-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 2300)
                };
        Employee emp=new Employee("Paul Ross",LocalDate.parse("2010-01-01"),2500);
        Employee[] empList=managers;
        //empList[0]=emp; //lead to runtime ArrayStoreException as managers and empList are referencing the same object
        for(Manager m:managers){
            out.println(m.getClass().getName());
            //m.setBonus(10);
        }
    }
}

