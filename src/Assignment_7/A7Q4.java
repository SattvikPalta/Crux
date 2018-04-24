package Assignment_7;

import java.util.Scanner;

public class A7Q4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scn.nextLine();

		System.out.println(palindrome(s));
	}

	public static boolean palindrome(String ques) {
		if (ques.length() <= 1)
			return true;

		char ch1 = ques.charAt(0);
		char ch2 = ques.charAt(ques.length() - 1);
		String roq = ques.substring(1, ques.length() - 1);

		if (ch1 != ch2) {
			return false;
		}

		return palindrome(roq);
	}
}
