package June12;

import java.util.Scanner;

public class logNumber {

	public static void main(String[] args) {
		int x = 243;
		int b = 3;
		System.out.print(log(x, b));
	}

	public static int power(int x, int n) {
		int power = (int) Math.pow(x, n);
		return power;
	}

	public static int log(int x, int n) {
		int counter = 1, rv = 0;
		while (true) {
			int pow = power(n, counter);
			if (pow == x)
				break;

			counter++;
		}

		rv = counter;
		return rv;
	}
}