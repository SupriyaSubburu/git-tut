package com.ciq.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OnlineReservation {
	    private static Map users = new HashMap<>();
	    private static Map reservations = new HashMap<>();
	    private static int reservationCounter = 1;

	    public static void main(String[] args) {
	        // Sample users for login
	        users.put("user1", "password1");
	        users.put("user2", "password2");

	        Scanner scanner = new Scanner(System.in);
	        System.out.println("Welcome to the Online Reservation System");
	        
	        // User login
	        System.out.print("Enter Login ID: ");
	        String loginId = scanner.nextLine();
	        System.out.print("Enter Password: ");
	        String password = scanner.nextLine();

	        if (authenticateUser(loginId, password)) {
	            System.out.println("Login successful!");
	            boolean exit = false;

	            while (!exit) {
	                System.out.println("\n1. Make a Reservation");
	                System.out.println("2. Cancel a Reservation");
	                System.out.println("3. Exit");
	                System.out.print("Choose an option: ");
	                int choice = scanner.nextInt();
	                scanner.nextLine(); // Consume newline

	                switch (choice) {
	                    case 1:
	                        makeReservation(scanner);
	                        break;
	                    case 2:
	                        cancelReservation(scanner);
	                        break;
	                    case 3:
	                        exit = true;
	                        break;
	                    default:
	                        System.out.println("Invalid option. Please try again.");
	                }
	            }
	        } else {
	            System.out.println("Invalid login credentials.");
	        }
	        scanner.close();
	    }

	    private static boolean authenticateUser(String loginId, String password) {
	        return users.containsKey(loginId) && users.get(loginId).equals(password);
	    }

	    private static void makeReservation(Scanner scanner) {
	        System.out.print("Enter your name: ");
	        String name = scanner.nextLine();
	        System.out.print("Enter train number: ");
	        String trainNumber = scanner.nextLine();
	        System.out.print("Enter train name: ");
	        String trainName = scanner.nextLine();
	        System.out.print("Enter class type: ");
	        String classType = scanner.nextLine();
	        System.out.print("Enter date of journey (YYYY-MM-DD): ");
	        String dateOfJourney = scanner.nextLine();
	        System.out.print("From (place): ");
	        String from = scanner.nextLine();
	        System.out.print("To (destination): ");
	        String to = scanner.nextLine();

	        String pnr = "PNR" + reservationCounter++;
	        reservations.put(pnr, String.format("Name: %s, Train Number: %s, Train Name: %s, Class: %s, Date: %s, From: %s, To: %s", 
	            name, trainNumber, trainName, classType, dateOfJourney, from, to));
	        
	        System.out.println("Reservation successful! Your PNR number is: " + pnr);
	    }

	    private static void cancelReservation(Scanner scanner) {
	        System.out.print("Enter your PNR number: ");
	        String pnr = scanner.nextLine();

	        if (reservations.containsKey(pnr)) {
	            System.out.println("Reservation details: " + reservations.get(pnr));
	            System.out.print("Do you want to confirm cancellation? (yes/no): ");
	            String confirmation = scanner.nextLine();

	            if (confirmation.equalsIgnoreCase("yes")) {
	                reservations.remove(pnr);
	                System.out.println("Reservation cancelled successfully.");
	            } else {
	                System.out.println("Cancellation aborted.");
	            }
	        } else {
	            System.out.println("Invalid PNR number.");
	        }
	    }
	}


