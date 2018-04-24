package Assignment_7;

import java.util.Scanner;

public class A7Q15 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a String");
		String ques = scn.nextLine();

		System.out.println(checkParenthesis(ques, ""));
	}

	public static boolean checkParenthesis(String ques, String ans) {
		if (ques.length() == 0) {
			if (ans.length() == 0)
				return true;
			else
				return false;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ch == ')' || ch == '}' || ch == ']') {
			if (ans.length() == 0) 
				return false;
		}

		if (ch == '(' || ch == '{' || ch == '[')
			ans = ans + ch;
		
		else if (ch == ')' && ans.charAt(ans.length() - 1) == '(')
			ans = ans.substring(0, ans.length() - 1);
		
		else if (ch == '}' && ans.charAt(ans.length() - 1) == '{')
			ans = ans.substring(0, ans.length() - 1);
		
		else if (ch == ']' && ans.charAt(ans.length() - 1) == '[')
			ans = ans.substring(0, ans.length() - 1);

		return checkParenthesis(roq, ans);
	}

}