package com.tuhin.random;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();  // create Random object
        int low=20,high=55, trick_variable, user_guess = 0, chances=5;
        int machine_guess = random.nextInt(high - low) + low;
        boolean correct_guess = false;
        String suggestion, confidence;

        Scanner sc = new Scanner(System.in);  // create scanner object
        System.out.print("Enter a guess:");  // ask the user for the first guess

        // redefine low and high to give user a guessing hint when guess is within 5 neighbouring numbers
        low  = machine_guess - 5;
        high = machine_guess + 5;
        while (chances>0){
            user_guess = sc.nextInt();
            trick_variable = random.nextInt(2);  // select a trick number between 0 and 1
            if (trick_variable == 1){  // based on the value of trick variable ask user question for confidence
                System.out.print("Are you sure this is the right number (Yes/no):");
                confidence = sc.next();
                if (confidence.compareToIgnoreCase("no") == 0){  // if user has no confidence, repeat the steps, do not deduct chances
                    System.out.println("Okay, Try another time (no chances lost)");
                    continue;  // skip rest of the loop body
                }
            }
            if (user_guess != machine_guess){  // if user's guess is not correct
                System.out.println("Close enough! Try again! ("+ chances +") chances remaining");
                if (user_guess >= low && user_guess <= high){  // but guess is in the range of the correct guesses
                    System.out.println("You are already in the guessing range, try between 5 neighbouring numbers");
                }
                else{
                    if(user_guess > high){
                        suggestion = "try something smaller!";
                    }
                    else
                        suggestion = "try something larger!";
                    System.out.println("You are too much outside guessing range, "+ suggestion);
                }
            }
            else{
                System.out.println("Congratulations! You guessed the number correctly as "+ user_guess);
                correct_guess = true;
                break;
            }
            chances --;
            System.out.println("[remaining " + chances + " chances]");
        }
        if(!correct_guess){
            System.out.println("Sorry you failed to guess it correctly!\n" +
                    "The number guess by the machine was " + machine_guess + ", your last guess was " + user_guess);
        }

    }
}
