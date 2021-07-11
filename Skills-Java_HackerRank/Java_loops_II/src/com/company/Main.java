package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            int mul_factor = 1;
            for (int x = 0; x < n; x++) {
                int tn = a + mul_factor * b;
                System.out.print(tn + " ");
                mul_factor *= 2;
                a = tn;
            }
            System.out.println();

        }
        in.close();
    }
}
