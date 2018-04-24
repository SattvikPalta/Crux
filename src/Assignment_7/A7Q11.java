package Assignment_7;

import java.util.Scanner;

public class A7Q11 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String ques = scn.nextLine();

//		System.out.println(count(ques, 0));
//		count2(ques, "", 0);
	}

	public static int count(String ques, int counter) {
		if (ques.length() <= 2) {
			return counter;
		}

		char ch1 = ques.charAt(0);
		char ch2 = ques.charAt(1);
		char ch3 = ques.charAt(2);
		String roq = ques.substring(1);

		if (ch1 == 'a' && ch2 == 'a' && ch3 == 'a')
			counter++;

		return count(roq, counter);
	}

	public static void count2(String ques, String ans, int counter) {
		if (ques.length() == 0) {
			System.out.println(counter);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		if (ch == 'a' && ans.length() <= 3)
			ans = ans + ch;
		else
			ans = "";

		if (ans.equals("aaa")) {
			counter++;
			ans = "";
		}

		count2(roq, ans, counter);
	}
}