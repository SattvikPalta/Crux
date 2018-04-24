package Assignment_2;

import java.util.Scanner;

public class A2Q7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number of lines");
		int n = scn.nextInt();
		
		int row = 1, val = 1;
		while (row <= n) {
			int cv = 1;
			while (cv <= row) {
				System.out.print(val + "\t");
				cv++;
				val++;
			}
			row++;
			System.out.println();
		}
	}
}
