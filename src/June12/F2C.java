package June12;

import java.util.Scanner;

public class F2C {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.print("Min Fahrenheit: ");
		int minf = scn.nextInt();

		System.out.print("Step Fahrenheit: ");
		int stepf = scn.nextInt();

		System.out.print("Max Fahrenheit: ");
		int maxf = scn.nextInt();

		int tempf = minf;
		while (tempf <= maxf) {
			int tempc = (int) ((5.0 / 9) * (tempf - 32));
			tempf = tempf + stepf;
			System.out.println(tempf + " " + tempc);
		}
	}
}