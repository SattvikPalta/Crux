package June7;

import java.util.Scanner;

public class fibonacciHard {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		int first = 0, second = 1, third = 0, i = 0;
		while (i < n) {
			third = first + second;
			first = second;
			second = third;
			i++;
		}
		System.out.println(first);
	}

}
