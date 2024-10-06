package com.ciq.task;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        Random random = new Random();
	        int numberToGuess = random.nextInt(100) + 1; 
	        // Random number between 1 and 100
	        int numberOfTries = 0;
	        int maxAttempts = 10; 
	        // Limit the number of attempts
	        boolean hasGuessedCorrectly = false;

	        System.out.println("Welcome to 'Guess the Number'!");
	        System.out.println("I have selected a number between 1 and 100.");
	        System.out.println("You have " + maxAttempts + " attempts to guess it.");

	        while (numberOfTries < maxAttempts && !hasGuessedCorrectly) {
	            System.out.print("Enter your guess: ");
	            int userGuess = scanner.nextInt();
	            numberOfTries++;

	            if (userGuess < 1 || userGuess > 100) {
	                System.out.println("Please guess a number between 1 and 100.");
	            } else if (userGuess < numberToGuess) {
	                System.out.println("Higher! Try again.");
	            } else if (userGuess > numberToGuess) {
	                System.out.println("Lower! Try again.");
	            } else {
	                hasGuessedCorrectly = true;
	                System.out.println("Congratulations! You've guessed the number in " + numberOfTries + " attempts.");
	            }
	        }

	        if (!hasGuessedCorrectly) {
	            System.out.println("Sorry! You've used all your attempts. The number was: " + numberToGuess);
	        }

	        scanner.close();
	    }
	}

