package June9;

import java.util.Scanner;

public class sb2D {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();

		System.out.println("Specify source base: ");
		int sb = scn.nextInt();

		int dec = 0, db = 10, rem = 0, pow = 1;
		
		while (n != 0) {
			rem = n % db;
			n = n / db;
			dec = dec + rem * pow;
			pow = sb * pow;
		}
		
		System.out.println(dec);
	}

}