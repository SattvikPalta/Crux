package Assignment_5;

import java.util.Scanner;

public class A5Q4 {

	public static void main(String[] args) {
		System.out.println(replace_ascii(takeInput()));
	}

	public static String takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");

		String s = scn.next();
		return s;
	}

	public static String replace_ascii(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char nch = '\0';

			if (ch % 2 == 0)
				nch = (char) (ch - 1);

			else
				nch = (char) (ch + 1);

			sb.append(nch);
		}

		return sb.toString();
	}
}
