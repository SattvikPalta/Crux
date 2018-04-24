package June7;

import java.util.Scanner;

public class reverseNumber {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter a Number: ");
		int n = scn.nextInt();
		int reverse = 0;
		while (n != 0) {
			reverse = reverse * 10;
			reverse = reverse + n % 10;
			n = n / 10;
		}
		System.out.print(reverse);
	}

}