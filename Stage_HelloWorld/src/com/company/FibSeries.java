package com.company;

import java.util.Scanner;

public class FibSeries {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        System.out.print("Number of terms you want to print:");
        int tot_count, i, before_previous=0, previous = 0, current = 0;
        tot_count = sc.nextInt();
        for(i=0;i<tot_count;i++){
            if (i<1){
                System.out.printf("%d,",current);
                previous = 1;
            }
            else {
                current = previous + before_previous;
                before_previous = previous;
                previous = current;
                if(i!=tot_count-1)
                    System.out.printf("%d,",current);
                else
                    System.out.print(current);
            }
        }
    }
}
