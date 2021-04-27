package com.tuhin.collections;

import javax.swing.plaf.basic.BasicTableHeaderUI;

public class Student {
    private final String name;
    private String reg_no;
    private final String roll_no;
    private int Batch_year;
    private String gender;

    public Student(String name, String roll_no, String gender, int batch) {
        this.name = name;
        this.roll_no = roll_no;
        this.gender = gender;
        this.Batch_year = batch;
    }

    public String getDetails() {
        return "Student Name: " + name + "\nRoll Number: " + roll_no +" \nGender: " + gender +
                "\nBatch Year: " + Batch_year;
    }
}
