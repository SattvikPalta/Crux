package June7;

import java.util.Scanner;

public class pattern1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter no. of lines");
		int n = scn.nextInt();

		int row = 1;
		int nst = 1;
		int nsp = n - 1;

		while (row <= (2 * n) - 1) {
			int cst = 1, val = 1, csp = 1;

			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}

			if (row <= n) {
				val = row;
			} else {
				val = 2 * n - row;
			}

			while (cst <= nst) {
				System.out.print(val);

				if (cst <= nst / 2) {
					val++;
				} else {
					val--;
				}
				cst++;
			}
			if (row < n) {
				nsp--;
				nst = nst + 2;
			} else {
				nsp++;
				nst = nst - 2;
			}

			row++;
			System.out.print("\n");
		}
	}

}
