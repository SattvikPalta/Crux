package June9;

import java.util.Scanner;

public class rotateNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();

		System.out.println("Enter rotation");
		int r = scn.nextInt();

		int l = 0;

		int n1 = n;

		while (n1 != 0) {
			n1 = n1 / 10;
			l++;
		}

		r = r % l;
		if (r < 0) {
			r = r + l;
		}

		int div = (int) Math.pow(10, r);
		int mul = (int) Math.pow(10, l - r);

		int rem = n % div;
		n = n / div;
		n = rem * mul + n;
		System.out.println(n);
	}
}