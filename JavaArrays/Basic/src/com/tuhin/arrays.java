package com.tuhin;

import java.util.Scanner;

public class arrays {
    void print_students(String[] students){
        System.out.print("[");
        for(String student : students){
            if (student !=  null){
                System.out.print(student + ",");
            }
            else
                break;
        }
        System.out.println("]");
    }
    boolean isStudent(String name, String[] students){
        for (String student : students) {
            if (student != null && student.compareToIgnoreCase(name) == 0) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // declare array of size 5
        String[] students = new String[5];
        Scanner sc = new Scanner(System.in);
        String name;
        arrays obj = new arrays();  // create class instance
        System.out.print("Enter 5 students name:\n");
        for (int i = 0; i<5; i++){
            System.out.print("Student [" + i + "] = ");
            name  = sc.nextLine();
            if (i>0 && obj.isStudent(name, students)){
                System.out.println("Student " + name + " already in students list.");
                obj.print_students(students);
                i-=1;
                continue;
            }
            students[i] = name;
            System.out.println("Student: " + name + " registered successfully, you can register " + (4-i) + " more students");
        }

        obj.print_students(students);
    }
}
