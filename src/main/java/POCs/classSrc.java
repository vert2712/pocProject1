package POCs;

import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.lang.reflect.*;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

public class classSrc{
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

        Arrays.sort(empList,Comparator.comparing(Employee::getName).thenComparing(Employee::getHireDate));
        Arrays.sort(empList, Comparator.comparing(Employee::getName,Comparator.nullsFirst(Comparator.naturalOrder())));
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
        //Employee emp=new Employee("Paul Ross",LocalDate.parse("2010-01-01"),2500);
        //Employee[] empList=managers;
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

    public static void genericArrayCopy(){
        Employee[] empList=new Employee[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Employee("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500)
                };

        Object newArray = Array.newInstance(empList.getClass().getComponentType(),20);
        System.arraycopy(empList,0,newArray,0,Math.min(empList.length,20));
        Employee[] empList2=(Employee[]) newArray;

    }

    public static void getDiffPersons(){
        Person[] empList=new Person[]
                {
                        new Manager("Boss1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Employee("Employee1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500),
                        new Student("Student1","major role", new int[]{1,2,3})
                };

        for(Person p:empList){
            out.println(p.toString());
        }
    }

    public void doJob() {
        Size s=Enum.valueOf(Size.class,"SMALL");
        out.println(s.getDescription());
        Size s2 =Size.values()[0];


    }

    public static void getReflection() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cl=Employee.class;
        Employee e =new  Employee("Employee1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500);
        Class cl2=e.getClass();
        Constructor c = cl.getDeclaredConstructor(String.class, LocalDate.class,double.class);//Double.TYPE
        Employee e2=(Employee)c.newInstance(new Object[]{"Employee1", LocalDate.parse("1900-01-01", DateTimeFormatter.ofPattern("yyyy-MM-DD")), 1500});
        String m = Modifier.toString(cl.getModifiers());
        Method[] meths = cl.getDeclaredMethods();
        Arrays.stream(meths).filter(x->Modifier.isPrivate(x.getModifiers())).forEach(x-> out.println(x.getName()+" "+x.getReturnType()+" "+Modifier.toString(x.getModifiers())));
        Field[] f=cl.getDeclaredFields();
        List am = Arrays.stream(meths).flatMap(p-> Stream.of(p.getModifiers(),p.getName())).collect(Collectors.toList());
        List am2 = Arrays
                .stream(meths)
                .map(p-> (new Object[]{p.getModifiers(),p.getName()}))
                .filter(x->Modifier.isStatic((int)(x[0])) && Modifier.isPublic((int)x[0]))
                .collect(Collectors.toList());
        Field f1=cl2.getDeclaredField("hireDate");
        f1.setAccessible(true);
        cl2.getMethod("getName").invoke(e2);
        Object o1=f1.get(e);
        out.println(o1);
    }


    public static void getStudents(){
        Student st1=new Student(
                "Student1",
                "major1",
                new int[]{1,2,3});
        try {
            Student st2=st1.clone();
            out.println(Arrays.toString(st1.getLevels()));
            out.println(Arrays.toString(st2.getLevels()));
            st2.setLevel(1,100);
            out.println(Arrays.toString(st1.getLevels()));
            out.println(Arrays.toString(st2.getLevels()));
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    public static void lambdaTest(String text){
        ActionListener ac=event->{
            out.println(text);
        };
        new Timer(1000,ac);
    }


}

