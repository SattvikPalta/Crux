package Assignment_8A;

import java.util.Scanner;

public class A8AQ1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a String");
		String ques = scn.nextLine();
		// System.out.println(countSubs(ques, 0));
		// System.out.println(Csubseq(ques, "", 0));
	}

	public static int countSubs(String ques, int count) {
		if (ques.length() == 0) {
			return (int) Math.pow(2, count);
		}
		return countSubs(ques.substring(1), count + 1);
	}

	public static int Csubseq(String ques, String ans, int count) {
		if (ques.length() == 0)
			return count + 1;

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		int a = Csubseq(roq, ans, count);
		int b = Csubseq(roq, ans + ch, count);
		return a + b;
	}
}
