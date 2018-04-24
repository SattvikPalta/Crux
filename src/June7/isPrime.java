package June7;

import java.util.Scanner;

public class isPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		int div = 2;

		while (div < n) {
			if (n % div == 0) {
				System.out.print("Not Prime");
				return;
			} else {
				div++;
			}
		}
		System.out.print("Prime");
	}
}