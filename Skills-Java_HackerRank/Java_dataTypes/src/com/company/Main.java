package com.company;

import java.util.Scanner;

public class Main {

    static class DataType{
        // you have to remove static keyword to pass test cases on HackerRank
        double min_incl_limit, max_incl_limit;
        String name;

        /**
         * Class to define data type max and min limits
         * check if a certain user input is possible in the corresponding data-types,
         * if yes:
         *      print * $data-type-name
         * else:
         *      pass
         * @param name name of the data-type
         * @param min minimum limit for the datatype
         * @param max maximum limit for the datatype
         */
        public DataType(String name, double min, double max) {
            this.name = name;
            this.min_incl_limit = min;
            this.max_incl_limit = max;
        }

        /**
         * check if the passed data fits in the class max-min limit
         * @param n input number Long type
         */
        void fit_possible(Long n){
            if (n>=min_incl_limit && n<=max_incl_limit){
                System.out.println("* "+name);
            }
        }
    }

    public static void main(String []argh)
    {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();

        for(int i=0;i<t;i++)
        {

            try
            {
                long x=sc.nextLong();
                System.out.println(x+" can be fitted in:");

                // create data types
                DataType type_bytes = new DataType("byte", -128, 127);
                DataType type_short = new DataType("short", -32768, 32767);
                DataType type_int = new DataType("int", Math.pow(-2, 31), Math.pow(2, 31) - 1);
                DataType type_long = new DataType("long", Math.pow(-2, 63), Math.pow(2, 63) - 1);

                type_bytes.fit_possible(x);
                type_short.fit_possible(x);
                type_int.fit_possible(x);
                type_long.fit_possible(x);
                //Complete the code
            }
            catch(Exception e)
            {
                System.out.println(sc.next()+" can't be fitted anywhere.");
            }

        }
    }
}
