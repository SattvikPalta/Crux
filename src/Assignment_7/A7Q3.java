package Assignment_7;

import java.util.Scanner;

public class A7Q3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String str1 = scn.nextLine();
		
		System.out.println("Enter another string");
		String str2 = scn.nextLine();
		
		System.out.println(testReverse(str1, str2));
	}

	public static boolean testReverse(String s1, String s2) {
		if (s1.length() != s2.length())
			return false;

		if (s1.length() == 0 || s2.length() == 0)
			return true;

		char ch1 = s1.charAt(0);
		String ros1 = s1.substring(1);

		char ch2 = s2.charAt(s2.length() - 1);
		String ros2 = s2.substring(0, s2.length() - 1);

		if (ch1 != ch2) {
			return false;
		}

		return testReverse(ros1, ros2);
	}
}