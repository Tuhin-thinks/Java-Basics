package com.company;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);

        int LineCount = 1;
        while (sc.hasNextLine()){
            String line_content = sc.nextLine();
            System.out.println(LineCount + " " + line_content);
            LineCount ++;
        }

    }
}
