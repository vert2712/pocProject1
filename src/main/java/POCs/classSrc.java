package POCs;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import static java.lang.System.out;


enum Size{
    SMALL("S","some small description here"),MEDIUM("M", "some medium text here");

    private String abbreviation;
    private String description;

    Size(String abbreviation, String description){
        this.abbreviation=abbreviation;
        this.description=description;
    }

    public String getAbbreviation(){
        return this.abbreviation;
    }

    public String getDescription(){
        return this.description;
    }
}

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

    public static void getMixedArray() {
        Employee[] empList=new Employee[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Employee("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500)
                };

        for(Employee e: empList) {
            if (e instanceof Manager) {
                Manager m=(Manager)e;
                out.println(m.getName());
            }
        }
    }

    public static void getDiffPersons(){
        /*Person[] empList=new Person[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Employee("Employee1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Student("Student1","major role")
                };

        for(Person p:empList){
            out.println(p.toString());
        }*/
    }

    public void doJob() {
        Size s=Enum.valueOf(Size.class,"SMALL");
        out.println(s.getDescription());
        Size s2 =Size.values()[0];
    }

    public void find(int idx){
        Class cl=Employee.class;
        Employee e =new  Employee("Employee1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500);
        Class cl2=e.getClass();
        //cl.getDeclaredConstructor().newInstance();
    }
}

