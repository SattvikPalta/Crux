package Assignment_8A;

import java.util.Scanner;

public class A8AQ4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a String");
		String que = scn.nextLine();
		
//		System.out.println(countPm(que));
//		System.out.println(Countpermutations(que, "", 0));
	}

	public static int countPm(String s) {
		if (s.length() == 0)
			return 1;

		return s.length() * countPm(s.substring(1));
	}

	public static int Countpermutations(String que, String ans, int count) {
		if (que.length() == 0)
			return count + 1;

		for (int i = 0; i < que.length(); i++) {
			char ch = que.charAt(i);
			String roq = que.substring(0, i) + que.substring(i + 1);
			count = Countpermutations(roq, ans + ch, count);
		}
		return count;
	}
}
