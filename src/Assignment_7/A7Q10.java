package Assignment_7;

import java.util.Scanner;

public class A7Q10 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String ques = scn.nextLine();

		twins(ques, 0);
	}

	public static void twins(String ques, int count) {
		if (ques.length() <= 2) {
			System.out.println(count);
			return;
		}

		char ch1 = ques.charAt(0);
		char ch2 = ques.charAt(1);
		char ch3 = ques.charAt(2);
		String roq = ques.substring(1);

		if (ch1 != ch2 && ch1 == ch3)
			count++;

		twins(roq, count);
	}
}
