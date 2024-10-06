package com.ciq.task;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExamination {
	private static String username = "user";
	private static String password = "password";
	private static boolean loggedIn = false;
	private static String[] questions = {
			"1. What is the capital of France?\n a) Berlin\n b) Madrid\n c) Paris\n d) Rome",
			"2. What is 2 + 2?\n a) 3\n b) 4\n c) 5\n d) 6" };
	private static char[] answers = { 'c', 'b' };
	private static char[] userAnswers = new char[questions.length];
	private static int timeLimit = 30;
	// 30 seconds
	private static Timer timer;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("1. Login\n2. Exit");
			int choice = scanner.nextInt();
			if (choice == 1) {
				login(scanner);
			} else {
				break;
			}
		}
		scanner.close();
	}

	private static void login(Scanner scanner) {
		System.out.print("Username: ");
		String inputUsername = scanner.next();
		System.out.print("Password: ");
		String inputPassword = scanner.next();

		if (inputUsername.equals(username) && inputPassword.equals(password)) {
			loggedIn = true;
			System.out.println("Login successful!");
			startExam(scanner);
		} else {
			System.out.println("Invalid credentials. Please try again.");
		}
	}

	private static void startExam(Scanner scanner) {
		System.out.println("Starting the exam. You have " + timeLimit + " seconds.");
		startTimer();

		for (int i = 0; i < questions.length; i++) {
			System.out.println(questions[i]);
			System.out.print("Your answer: ");
			userAnswers[i] = scanner.next().charAt(0);
		}

		autoSubmit();
	}

	private static void startTimer() {
		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				System.out.println("\nTime is up! Submitting your answers...");
				autoSubmit();
			}
		}, timeLimit * 1000);
	}

	private static void autoSubmit() {
		timer.cancel();
		loggedIn = false;
		int score = 0;
		for (int i = 0; i < answers.length; i++) {
			if (userAnswers[i] == answers[i]) {
				score++;
			}
		}
		System.out.println("Your score: " + score + "/" + answers.length);
		System.out.println("Logging out...");
	}
}
