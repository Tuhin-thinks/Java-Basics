package com.tuhin.contacts;

import java.util.Scanner;

public class Contacts {
    public static void main(String[] args) {
        String[] names = {"Mason", "Dr. Derulo", "Tuhin", "Jason"};
        int[] numbers = {154564, 48787, 45431, 141354};

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a name to search in phonebook:");
        String search = sc.nextLine();
        String name;
        int number, found=0;
        for(int i=0;i< names.length;i++){
            name = names[i];
            number = numbers[i];
            if (name.equals(search)){
                System.out.println("\tname:" + name + "\n\tnumber:" + number + "\n--------------\n");
                found = 1;
            }
        }
        if(found==0){
            System.out.println(search + " not in phonebook!");
        }
    }
}
