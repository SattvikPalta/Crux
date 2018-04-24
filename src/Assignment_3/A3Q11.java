package Assignment_3;

import java.util.Scanner;

public class A3Q11 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter 2 numbers");
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();

		GCD(n1, n2);
	}

	public static void GCD(int n1, int n2) {
		int dividend = 0, divisor = 0;
		if (n1 > n2) {
			dividend = n1;
			divisor = n2;
		} else {
			dividend = n2;
			divisor = n1;
		}

		while (true) {
			int rem = dividend % divisor;
			dividend = divisor;
			if (rem != 0)
				divisor = rem;
			else
				break;
		}
		System.out.println(divisor);
	}
}
