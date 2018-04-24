package Assignment_3;

import java.util.Scanner;

public class A3Q12 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter 2 numbers");
		int number1 = scn.nextInt();
		int number2 = scn.nextInt();

		System.out.println(LCM(number1, number2));
	}

	public static int LCM(int n1, int n2) {
		int a = (n1 > n2) ? n1 : n2;
		while (true) {
			if (a % n1 == 0 && a % n2 == 0)
				return a;

			++a;
		}
	}
}
