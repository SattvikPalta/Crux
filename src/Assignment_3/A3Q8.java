package Assignment_3;

import java.util.Scanner;

public class A3Q8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = scn.nextInt();

		System.out.println(inverse(number));
	}

	public static boolean inverse(int number) {
		int inverse = 0, place = 1;
		while (number != 0) {
			int rem = number % 10;
			number = number / 10;
			int mul = (int) Math.pow(10, rem - 1);
			inverse = inverse + place * mul;
			place++;
		}

		if (inverse == number)
			return true;
		else
			return false;
	}
}
