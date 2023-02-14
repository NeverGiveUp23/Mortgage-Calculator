package org.example;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public int calculateWage(int extraHours){
        return baseSalary + (hourlyRate * extraHours);
    }


    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        if(hourlyRate <= 0){
            throw new IllegalArgumentException("Hourly Rate must not be $0");
        }

        this.hourlyRate = hourlyRate;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        if(baseSalary <= 0){
            throw new IllegalArgumentException("Salary cannot be 0 or less");
        }

        this.baseSalary = baseSalary;
    }
}
