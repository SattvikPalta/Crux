package Assignment_3;

import java.util.Scanner;

public class A3Q10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int number1 = scn.nextInt();

		System.out.println("Enter another number");
		int number2 = scn.nextInt();

		armstrongNumbers(number1, number2);
	}

	public static void armstrongNumbers(int number1, int number2) {
		if (number1 > number2)
			System.out.println("Wrong Input");

		else {
			for (int i = number1; i <= number2; i++) {
				if (armstrong(i) == true)
					System.out.println(i);
			}
		}
	}

	public static boolean armstrong(int number) {
		int temp = number;
		int armstrong = 0;
		while (temp != 0) {
			int rem = temp % 10;
			temp = temp / 10;
			int place = (int) Math.pow(rem, 3);
			armstrong = armstrong + place;
		}

		if (armstrong == number)
			return true;
		else
			return false;
	}

}
