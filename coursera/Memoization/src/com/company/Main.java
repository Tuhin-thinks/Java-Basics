package com.company;

public class Main {

    public static void main(String[] args) {
	    Factorial factorial = new Factorial();

        int number = 10;
        long time_a = System.nanoTime();
        System.out.println("Calculating factorial of "+ number +"");
        int result = factorial.calculate(number);

        System.out.println("Factorial of "+ number +" is : "+ result +"");
        long duration = System.nanoTime() - time_a;
        System.out.printf("Took %8.5f mils.\n", duration/1e6);

        System.out.println();

        number = 11;  // calculating factorial of 11 will be very fast because factorial of 10 is already "memoized"
        time_a = System.nanoTime();
        System.out.println("Calculating factorial of "+ number +"");
        result = factorial.calculate(number);
        duration = System.nanoTime() - time_a;
        System.out.println("Factorial of "+ number +" is : "+ result +"");
        System.out.printf("Took %8.5f mils.\n", duration/1e6);

    }
}
