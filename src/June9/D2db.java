package June9;

import java.util.Scanner;

public class D2db {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number in decimal");
		int n = scn.nextInt();
		
		System.out.println("Enter destination base: ");
		int db = scn.nextInt();

		int rem = 0, bin = 0, pow = 1;
		while (n != 0) {
			rem = n % db;
			n = n / db;
			bin = bin + rem * pow;
			pow = 10 * pow;
		}
		
		System.out.println(bin);
	}

}
