package Assignment_3;

import java.util.Scanner;

public class A3Q6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = scn.nextInt();

		System.out.println("Enter digit to whose frequency is to be obtained");
		int digit = scn.nextInt();

		System.out.println(frequency(number, digit));
	}

	public static int frequency(int number, int digit) {
		int count = 0;
		while (number != 0) {
			int rem = number % 10;
			if (rem == digit)
				count++;

			number = number / 10;
		}
		return count;
	}
}
