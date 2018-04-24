package Assignment_8A;

import java.util.Scanner;

public class A8AQ2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a String");
		String que = scn.nextLine();

		System.out.println(countSubs(que, 0));
	}

	public static int countSubs(String que, int count) {
		if (que.length() == 0)
			return (int) Math.pow(3, count);

		return countSubs(que.substring(1), count + 1);
	}
}
