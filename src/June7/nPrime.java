package June7;

import java.util.Scanner;

public class nPrime {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter the nth number");
		int n = scn.nextInt();

		int div = 2, counter = 2;
		
		while (counter < n) {
			div = 2;
			while (div < counter) {
				if (counter % div == 0)
					break;

				div++;
			}
			
			if (div == counter)
				System.out.println(counter);

			counter++;
		}
	}
}