package Assignment_7;

import java.util.Scanner;

public class A7Q7 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String ques = scn.nextLine();

//		 System.out.println(shift(ques, ""));
//		 shift2(ques, "", 0);
	}

	public static String shift(String ques, String ans) {
		StringBuilder sb = new StringBuilder();
		if (ques.length() == 0)
			return ans;

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		ans = shift(roq, ans);

		if (ch == 'x')
			ans = ans + ch;
		else
			sb.append(ch);

		return sb.toString() + ans;
	}

	public static void shift2(String ques, String ans, int count) {
		if (ques.length() == 0) {
			for (int i = 0; i < count; i++)
				ans = ans + 'x';

			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ch == 'x')
			shift2(roq, ans, count + 1);
		else
			shift2(roq, ans + ch, count);
	}
}