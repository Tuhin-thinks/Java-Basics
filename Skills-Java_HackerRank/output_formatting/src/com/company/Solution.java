package com.company;

import java.util.Scanner;
import java.lang.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("================================");
        for(int i=0;i<3;i++){
            String s1=sc.next();
            int x=sc.nextInt();
            String str_part = String.format("%"+ -15 + "s", s1);
            String int_part = String.format("%"+ 3 + "s", x).replace(' ', '0');
            System.out.println(str_part + int_part);
        }
        System.out.println("================================");

    }
}



