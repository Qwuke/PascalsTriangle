package net.qwuke;

import java.util.Arrays;
import java.util.Scanner;

public class TriangleBuilder {

	public static void printArray(int[] array) {
		for (int i : array) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	public static void printArray(int[] currentRow, int depth, String[] numberContainer, int rowNumber) {
		if(rowNumber==1) {
			String arrCopy[] = Arrays.copyOf(numberContainer,numberContainer.length);
			arrCopy[depth]="1";
			for(String i:arrCopy) {
				System.out.print(i);
			}
			System.out.println();
		}
		String arrCopy[] = Arrays.copyOf(numberContainer,numberContainer.length);
		//index of first changed number in arrCopy = depth - rowNumber
		for(int posOfFirstChange = depth - rowNumber, index = 0; index < currentRow.length; posOfFirstChange += 2,index++) {
			//System.out.println(posOfFirstChange);
			String test = Integer.toString(currentRow[index]);
			arrCopy[posOfFirstChange] = test;
			//System.out.print(arrCopy[posOfFirstChange]);			
		}
		
		for(String s:arrCopy) {
			System.out.print(s);
		}
		System.out.println();
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String valid = "y"; // String for validating whether or not to continue based on y or n

		while (valid.equalsIgnoreCase("y")) {
			// First we validate user input
			System.out.println("Let's build some of Pascal's Triangle");
			System.out.println("How many levels do you want to go down the triangle? Feed me a positive int value: ");

			while (!sc.hasNextInt()) {
				sc.next(); // Handles the non int then waits for the next input, stopping infinite angry
							// messages/hang and exception simultaneously
				System.out.println("That wasn't an int! Try entering another value: ");
			}
			int depth = sc.nextInt(); // How deep we're calculating pascal's triangle as provided by the user

			int[] pascal = { 1 };
			int[] next;
			next = pascal;

			String[] positionsContainer = new String[(2 * depth)+1];
			Arrays.fill(positionsContainer, " ");

			for (int i = 2; depth + 2 > i; i++) {
				pascal = new int[i];
				pascal[0] = 1;
				pascal[i - 1] = 1;
				for (int j = 0; j <= i - 3; j++) {
					pascal[j + 1] = next[j] + next[j + 1];
				}
				//printArray(pascal);
				printArray(pascal,depth,positionsContainer,i-1);
				// printArray(pascal, depth, positions, i - 1);
				next = pascal;
			}

			sc.nextLine();// Input garbage collector line
			System.out.println("");
			System.out.println("Continue? Type y to continue or n to end the program");
			valid = sc.nextLine();
			while (!(valid.equalsIgnoreCase("y") || valid.equalsIgnoreCase("n"))) {
				System.out.println("That wasn't a valid input! Type y to continue or n to stop");
				valid = sc.nextLine();
			}
		} // If y, rerun the program
		sc.close();
	}

}
