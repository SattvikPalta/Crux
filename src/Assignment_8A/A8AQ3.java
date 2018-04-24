package Assignment_8A;

import java.util.Scanner;

public class A8AQ3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		String que = scn.nextLine();

		System.out.println(countKeypad(que));
	}

	public static String getCode(char ch) {
		if (ch == '1') {
			return "abc";
		} else if (ch == '2') {
			return "def";
		} else if (ch == '3') {
			return "ghi";
		} else if (ch == '4') {
			return "jkl";
		} else if (ch == '5') {
			return "mno";
		} else if (ch == '6') {
			return "pqrs";
		} else if (ch == '7') {
			return "tuv";
		} else if (ch == '8') {
			return "wx";
		} else if (ch == '9') {
			return "yz";
		} else {
			return ".;_";
		}
	}

	public static int countKeypad(String que) {
		if (que.length() == 0) 
			return 1;

		char ch = que.charAt(0);
		String roq = que.substring(1);

		int codeLen = getCode(ch).length();
		int sans = codeLen * countKeypad(roq);
		return sans;
	}
}
