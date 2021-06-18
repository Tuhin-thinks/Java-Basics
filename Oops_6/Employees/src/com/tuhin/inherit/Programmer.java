package com.tuhin.inherit;

import java.time.LocalDate;

public class Programmer extends Employee {
    private String role;
    int salary;
    public Programmer(String name, int age, char gender, int year_of_join, String mail_id, String role, int Salary) {
        super(name, age, gender, year_of_join, mail_id);
        this.role = role;
        this.salary = Salary;
    }
    public String getName(boolean print){
        if (print)
            System.out.println("Employees Name:" + super.name);
        return super.name;
    }

    public void printProgrammerDetails(){
        System.out.println("Name: " + super.name + "\n" +
                "Age: " + super.age + "\n" +
                "Gender: " + super.gender + "\n" +
                "Joining year: " + super.year_of_join + "\n" +
                "Employee Mail-Id: " + super.mail_id + "\n" +
                "Employee Role: " + role + "\n" +
                "Salary: " + salary + "\n");
    }
    public void increment(int amount){
        LocalDate localDate = LocalDate.now();
        int current_year = localDate.getYear();
        if ((current_year - year_of_join) >= 1){
            this.salary += amount;
            System.out.println("Salary increased to ₹" + salary);
        }
        else
            System.out.println(name + " is not eligible for a salary increment");
    }

    public void setRole(String role){
        this.role = role;
    }
}
