package Assignment_3;

import java.util.Scanner;

public class A3Q9 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int number = scn.nextInt();

		System.out.println(armstrong(number));
	}

	public static boolean armstrong(int number) {
		int temp = number;
		int armstrong = 0;
		while (temp != 0) {
			int rem = temp % 10;
			temp = temp / 10;
			int place = (int) Math.pow(rem, 3);
			armstrong = armstrong + place;
		}
		
		if(armstrong == number)
			return true;
		else
			return false;
	}
}
