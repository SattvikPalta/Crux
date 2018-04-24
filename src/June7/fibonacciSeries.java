package June7;

import java.util.Scanner;

public class fibonacciSeries {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		int n = scn.nextInt();
		
		int first = 0, second = 1, third = 0, i = 0;
		while (i < n) {
			System.out.println(first);
			third = first + second;
			first = second;
			second = third;
			i++;
		}
	}
}