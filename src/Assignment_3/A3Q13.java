package Assignment_3;

import java.util.Scanner;

public class A3Q13 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter number and its power");
		int n = scn.nextInt();
		int power = scn.nextInt();

		System.out.println(power(n, power));
	}

	public static int power(int n, int power) {
		int ans = 1;
		for (int i = 1; i <= power; i++)
			ans = ans * n;

		return ans;
	}
}
