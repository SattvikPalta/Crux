package Assignment_5;

import java.util.Scanner;

public class A5Q8 {

	public static void main(String[] args) {
		System.out.println(maxFrequencyChar(takeInput()));
	}

	public static char maxFrequencyChar(String s) {
		int[] arr = new int[256];

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			arr[ch]++;
		}

		int max = arr[0];
		int maxidx = 0;

		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
				maxidx = i;
			}
		}

		return (char) maxidx;
	}

	public static String takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter a string");
		String s = scn.next();

		return s;
	}
}
