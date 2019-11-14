package POCs;

public class Student extends Person {

    private String major;

    public Student(String pName, String pMajor){
        super(pName);
        this.major=pMajor;
    }

    public String getDescription() {
        return " student class with "+this.major;
    }
}
