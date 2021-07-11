package com.company;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{

    /**
    static String recurse_matcher(String line){
        Pattern p = Pattern.compile("<(.+)>(.*)</\\1>", Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(line);
        String matched_content = "None";

        while(matcher.find()){
            matched_content = matcher.group(2);
        }
        Matcher matcher2;
        matcher2 = p.matcher(matched_content);
        if(matcher2.find()){
            return recurse_matcher(matched_content);
        }
        if(matched_content.equals("") || line.equals(matched_content))
            return "None";
        return matched_content;
    }
    */


    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int testCases = Integer.parseInt(scan.nextLine());

        while (testCases-- > 0) {
            String line = scan.nextLine();

            boolean matchFound = false;
            Pattern r = Pattern.compile("<(.+)>([^<]+)</\\1>");
            Matcher m = r.matcher(line);

            while (m.find()) {
                System.out.println(m.group(2));
                matchFound = true;
            }
            if ( ! matchFound) {
                System.out.println("None");
            }
        }
    }
}