package Assignment_7;

import java.util.Scanner;

public class A7Q1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a number");
		String ques = scn.nextLine();
		System.out.println(sum(ques, 0));
	}

	public static int sum(String ques, int ans) {
		if (ques.length() == 0)
			return ans;

		char ch = ques.charAt(0);
		String roq = ques.substring(1);
		ans = sum(roq, ans + ch - '0');
		return ans;
	}
}