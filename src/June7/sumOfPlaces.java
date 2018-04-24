package June7;

import java.util.Scanner;

public class sumOfPlaces {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		int Esum = 0, Osum = 0, rem = 0, counter = 1;

		while (n != 0) {
			rem = n % 10;
			n = n / 10;
			if (counter % 2 == 0)
				Esum = Esum + rem;
			else
				Osum = Osum + rem;
			counter++;
		}
		System.out.println("Sum of odd places = " + Osum);
		System.out.println("Sum of even places = " + Esum);
	}
}