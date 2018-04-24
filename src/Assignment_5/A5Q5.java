package Assignment_5;

import java.util.Scanner;

public class A5Q5 {

	public static void main(String[] args) {
		System.out.println(asciiDiff(takeInput()));
	}

	public static String takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scn.next();

		return s;
	}

	public static String asciiDiff(String s) {
		StringBuilder sb = new StringBuilder();

		sb.append(s.charAt(0));
		for (int i = 0; i < s.length() - 1; i++) {
			char ch = s.charAt(i);
			char nch = s.charAt(i + 1);

			sb.append(nch - ch);
			sb.append(nch);
		}
		return sb.toString();
	}
}
