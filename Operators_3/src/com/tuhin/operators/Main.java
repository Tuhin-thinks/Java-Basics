package com.tuhin.operators;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you name:");
        String name = sc.nextLine();

        System.out.print("Enter your age:");
        int age = sc.nextInt();

        boolean decision = age >= 18 && age <= 25 || age >= 50 && age <= 70;
        if (decision){
            System.out.println("Congrats "+ name + "!!!, you are eligible for the 50% discount for the month");
        }
        else
            System.out.println(name + ", We are Sorry! You are not eligible for the grand discount!");
    }

}