package Assignment_6;

import java.util.Scanner;

public class A6Q5 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		System.out.println(ntriangle(n));
	}

	public static int ntriangle(int n) {
		if (n == 0)
			return 0;

		int sans = ntriangle(n - 1);
		int ans = n + sans;
		return ans;
	}
}