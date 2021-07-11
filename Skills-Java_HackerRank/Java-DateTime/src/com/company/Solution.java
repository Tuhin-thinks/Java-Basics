package com.company;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

class Result {

    /*
     * Complete the 'findDay' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. INTEGER month
     *  2. INTEGER day
     *  3. INTEGER year
     */

    public static String findDay(int month, int day, int year){
//        Calendar calendar = Calendar.getInstance();
//        int[] day_names = {Calendar.SUNDAY, Calendar.MONDAY, Calendar.MONDAY, Calendar.TUESDAY, Calendar.WEDNESDAY,
//                Calendar.THURSDAY, Calendar.FRIDAY, Calendar.SATURDAY, Calendar.SUNDAY};
//        calendar.set(year, Calendar.JULY, day);
//        int day_num = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.printf("year: %d, month: %d, date: %d\n", year, month, day);
        return LocalDate.of(year, month, day).getDayOfWeek().toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);

        int month = Integer.parseInt(scan.next());

        int day = Integer.parseInt(scan.next());

        int year = Integer.parseInt(scan.next());
        scan.nextLine();

        String res = Result.findDay(month, day, year);
        System.out.println(res);
        scan.close();
    }
}
