package Assignment_2;

import java.util.Scanner;

public class A2Q12 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of lines");
		int n = scn.nextInt();
		int row = 1;
		int nst = n / 2 + 1, nsp = 1;
		while (row <= n) {
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp++;
			}
			cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst++;
			}
			if (row <= n / 2) {
				nst--;
				nsp += 2;
			} else {
				nst++;
				nsp -= 2;
			}
			System.out.println("");
			row++;
		}
	}
}