package com.tuhin.inherit;

public class Main {
    public static void main(String[] args) {
        Programmer programmer = new Programmer("Tuhin Mitra", 21, 'M', 2021,
                "tuhinmitra190221@gmail.com", "Python Developer", 25000);
        programmer.increment(5000);  // applying a 5k increment
        System.out.println("Programmers Name:" + programmer.getName(false) + "\n" +
                "Salary: ₹" + programmer.salary);

        System.out.println("-------------Programmer's Details-----------------\n");
        programmer.printProgrammerDetails();
    }
}
