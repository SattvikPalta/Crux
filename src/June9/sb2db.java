package June9;

import java.util.Scanner;

public class sb2db {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int sbn = scn.nextInt();

		System.out.println("Enter source base: ");
		int sb = scn.nextInt();

		System.out.println("Enter destination base: ");
		int db = scn.nextInt();

		int dec = 0, pow = 1, rem = 0;

		while (sbn != 0) {
			rem = sbn % 10;
			sbn = sbn / 10;
			dec = dec + rem * pow;
			pow = sb * pow;
		}

		System.out.println(dec);

		int dbn = 0;
		pow = 1;
		while (dec != 0) {
			rem = dec % db;
			dec = dec / db;
			dbn = dbn + rem * pow;
			pow = 10 * pow;
		}

		System.out.println(dbn);
	}

}
