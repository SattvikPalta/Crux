package June9;

import java.util.Scanner;

public class B2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number in binary to convert it to decimal");
		int n = scn.nextInt();
		int rem = 0, bin = 0, pow = 1;

		while (n > 0) {
			rem = n % 10;
			n = n / 10;
			bin = bin + rem * pow;
			pow = 2 * pow;
		}

		System.out.println(bin);
	}
}