package Assignment_7;

import java.util.Scanner;

public class A7Q8 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String ques = scn.nextLine();

//		count(ques, 0);
//		remove(ques, "");
//		replace(ques, "");
	}

	public static void count(String ques, int counter) {
		if (ques.length() < 2) {
			System.out.println(counter);
			return;
		}

		String s = ques.substring(0, 2);
		String roq = ques.substring(1);

		if (s.equals("hi"))
			counter++;

		count(roq, counter);
	}

	public static void remove(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.println(ans + (ques.substring(0)));
			return;
		}

		String s = ques.substring(0, 2);
		String roq = ques.substring(1);

		if (s.equals("hi"))
			remove(roq.substring(1), ans);
		else
			remove(roq, ans + s.charAt(0));
	}

	public static void replace(String ques, String ans) {
		if (ques.length() < 2) {
			System.out.println(ans + ques);
			return;
		}

		String s = ques.substring(0, 2);
		String roq = ques.substring(1);

		if (s.equals("hi")) {
			roq = roq.substring(1);
			replace(roq, ans + "bye");
		} else {
			replace(roq, ans + s.charAt(0));
		}
	}
}
