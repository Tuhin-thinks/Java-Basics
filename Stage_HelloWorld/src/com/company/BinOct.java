package com.company;

import java.util.Scanner;

public class BinOct {
    static Scanner sc = new Scanner(System.in);

    static int bin_to_dec(int binary_num){
        // @param binary_num binary number to convert
        // @return decimal number generated from binary number
        int counter = 0, rem, decimal_number = 0;
        while (binary_num > 0){
            rem = binary_num % 10;
            decimal_number += rem * Math.pow(2, counter);
            binary_num /= 10;
            counter ++;
        }
        return decimal_number;
    }
    public static void main(String [] args){
        System.out.print("Enter binary number:");
        int binary_num = sc.nextInt();
        int octal_form = 0, counter = 0, blocks_3 = 0, block_to_dec = 0;
        while (binary_num > 0){
            blocks_3 = binary_num % 1000;
            block_to_dec = bin_to_dec(blocks_3);
            octal_form = block_to_dec * (int) Math.pow(10, counter) + octal_form ;
            binary_num /= 1000;
            counter ++;
        }
        System.out.println("to Octal number:"+octal_form);
    }
}
