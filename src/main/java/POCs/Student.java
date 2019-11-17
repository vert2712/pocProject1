package POCs;

import java.util.Date;

public class Student extends Person  implements coreInterface, newCoreInterface, Cloneable{

    private String major;
    private int[] levels;

    public Student(String pName, String pMajor, int[] pLevels){
        super(pName);
        this.major=pMajor;
        this.levels=pLevels;
    }

    public String getDescription() {
        return " student class with "+this.major;
    }

    public int[] getLevels(){
        return this.levels;
    }

    public void setLevel(int idx, int value){
        this.levels[idx]=value;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public Student clone() throws CloneNotSupportedException {
        Student newStudent =  (Student)super.clone();
        newStudent.levels= levels.clone();

        return newStudent;
    }
}
