package Assignment_2;

import java.util.Scanner;

public class A2Q11 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of lines");
		int n = scn.nextInt();

		int row = 1, nsp = n / 2, nst = 1;
		while (row <= 2 * n - 1) {
			int csp = 1, cst = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			if (row <= n / 2) {
				nsp--;
				nst = nst + 2;
			} else {
				nsp++;
				nst = nst - 2;
			}
			System.out.print("\n");
			row++;

		}
	}
}
