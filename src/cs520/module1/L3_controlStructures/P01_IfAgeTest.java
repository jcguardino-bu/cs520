package cs520.module1.L3_controlStructures;

import java.util.Scanner;

public class P01_IfAgeTest {

    public static void main(String[] args) {

        System.out.print("What is your age? ");

        // Create Scanner to solicit user input
        Scanner scanner = new Scanner(System.in);

        // Read input into a String variable when Enter is pressed
        String input = scanner.nextLine();

        // Convert the String input into an integer
        int age = Integer.parseInt(input);
        // Call the checkVotingAge() method
        checkVotingAge(age);

		// Close scanner
		scanner.close();
    }

    public static void checkVotingAge(int age) {

        // Perform conditional test using the value of age
        if (age >= 18) {
            // Condition was true
            System.out.println("You are old enough to vote");
        }

    }
}
