package POCs;

import java.time.LocalDate;
import java.util.Objects;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name, LocalDate hireDate, double salary) {
        super(name, hireDate, salary);
        setBonus(0);
    }

    public double getBonus(){
        return this.bonus;
    }

    public void setBonus(double pBonus) {
        this.bonus = pBonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }

    @Override
    public boolean equals(Object other){
        if (!super.equals(other))
            return false;

        Manager m=(Manager)other;
        return m.getSalary()==this.getSalary() && m.getHireDate()==this.getHireDate();
    }

    @Override
    public String toString(){
        return super.toString()+" bonus: "+this.getBonus();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),this.getBonus());
    }
}