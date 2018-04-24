package Assignment_7;

import java.util.Scanner;

public class A7Q14 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String ques = scn.nextLine();

		printParenthesis(ques, "");
	}

	public static void printParenthesis(String ques, String ans) {
		if (ques.length() == 0)
			return;

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ans.length() == 0)
			ans = ans + ch;

		else if (ch != ')' && ans.charAt(ans.length() - 1) == '(')
			System.out.print(ch);

		else if (ch == ')')
			ans = ans + ch;

		else
			ans = ans + ch;

		printParenthesis(roq, ans);

	}

}