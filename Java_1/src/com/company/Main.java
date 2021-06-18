package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // code to print table
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number to find table of:");
        int number = sc.nextInt();

        System.out.printf("----------------Printing table of %d------------\n", number);
        for(int i=0;i<10;i++){
            int res = number * (i+1);
            System.out.printf("%d x %d = %d\n", number, (i+1), res);
        }
    }
}
