package com.company;

import java.util.Scanner;

public class FibRecursive {
    static Scanner sc = new Scanner(System.in);
    static long recurse_fibonacci(long n){
        if ((n==0)||(n==1)) {
            return n;
        }
        return recurse_fibonacci(n-1) + recurse_fibonacci(n-2);
    }

    public static void main(String[] args){
        System.out.print("Number of terms you want to print in Fibonacci series:");
        int range = sc.nextInt();
        System.out.printf("[Recursive Result] Fibonacci term:(%d)=", range);
        System.out.println(recurse_fibonacci(range));
    }
}
