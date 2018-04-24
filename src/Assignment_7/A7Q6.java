package Assignment_7;

import java.util.Scanner;

public class A7Q6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scn.nextLine();

		duplicate(s, "");
	}

	public static void duplicate(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch1 = ques.charAt(0);
		String roq = ques.substring(1);

		if (roq.length() != 0) {
			char ch2 = ques.charAt(1);

			if (ch1 == ch2) {
				duplicate(roq, ans);
				return;
			}
		}
		duplicate(roq, ans + ch1);
	}
}
