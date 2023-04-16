package Student;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		boolean valid = true;
		int gradeVal = 0;
		int points = 0;
		int numOfCredits = 0;
		int untouchedCredits = 0; // can keep running total of credits without messing up points calculation
		String grade = "";

		while (valid) {// while user wants to keep inputting grades

			System.out.println("Enter number of credits for class ");
			while (!in.hasNextInt()) { // if user doesn't input integer, keep prompting user to enter a valid integer
				System.out.println("Please enter a valid integer");
				in.next();
			}

			numOfCredits = in.nextInt();
			untouchedCredits += numOfCredits;

			System.out.println("Enter grade for class ");
			grade = in.next();
			while (!"ABCDF".contains(grade.toUpperCase())) { // if user doesn't input a valid letter grade, keep
																// prompting user to enter valid letter
				System.out.println("Please enter a valid letter grade");
				grade = in.next();
			}

			switch (grade.toUpperCase()) { // depending on letter grade inputed, gradeVal will be one of the following
			case "A":
				gradeVal = 4;
				break;
			case "B":
				gradeVal = 3;
				break;
			case "C":
				gradeVal = 2;
				break;
			case "D":
				gradeVal = 1;
				break;
			case "F":
				gradeVal = 0;
				break;
			}

			points += gradeVal * numOfCredits; // keep totaling points of all grades entered

			System.out.println("Will you be entering more grades (Y/N)?");
			String userContinues = in.next().toUpperCase();
			while (!(userContinues.contains("Y") || userContinues.contains("N"))) {// if user doesn't enter a valid
																					// response to whether they want to
																					// continue entering grades, keep
																					// prompting them to enter a valid
																					// response
				System.out.println("Error. Please enter Y or N");
				userContinues = in.next().toUpperCase();
			}
			if (userContinues.contains("N")) {// in case user enters no, it should still work
				valid = false; // if user doesn't want to continue, valid is set to false and entire while loop
								// ends
			}
		}

		// do this calculation after all classes the user wanted to enter are entered
		// (after while loop is done)
		double gpa = (double) points / untouchedCredits;
		if (gpa > 3.0) {
		System.out.printf("Your GPA is %.2f. ", gpa);
		System.out.print("Congrats!");
			
		}
		else {
			System.out.printf("Your GPA is %.2f. ", gpa);
			System.out.print("Keep Working Hard!");
		}
	}
}
