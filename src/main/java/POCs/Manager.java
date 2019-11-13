package POCs;

import java.time.LocalDate;

public class Manager extends Employee {

    private double bonus;

    public Manager(String name, LocalDate hireDate, double salary) {
        super(name, hireDate, salary);
        setBonus(0);
    }

    public void setBonus(double pBonus) {
        this.bonus = pBonus;
    }

    public double getSalary() {
        return super.getSalary() + this.bonus;
    }
}