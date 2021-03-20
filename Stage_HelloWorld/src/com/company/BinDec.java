package com.company;

import java.util.Scanner;

public class BinDec {
    public static void main(String [] args){
        Scanner sc =  new Scanner(System.in);
        int binary_number = 0;
        System.out.print("Enter the binary number:");
        binary_number = sc.nextInt();
        int copy_binary = binary_number;
        int counter = 0, rem, sum = 0;
        while (binary_number > 0){
            rem = binary_number % 10;
            sum += rem * Math.pow(2, counter);
            binary_number /= 10;
            counter ++;
        }
        System.out.println("The Decimal number for entered binary number:"+ copy_binary +", is:"+sum);
    }
}
