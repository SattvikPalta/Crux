package June9;

import java.util.Scanner;

public class D2B {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number in decimal to convert it to binary");
		int n = scn.nextInt();
		int rem = 0, bin = 0, pow = 1;
		
		while (n > 0) {
			rem = n % 2;
			n = n / 2;
			bin = bin + rem * pow;
			pow = 10 * pow;
		}
		
		System.out.println(bin);
	}

}
