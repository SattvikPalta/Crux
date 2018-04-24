package Assignment_4;

import java.util.Scanner;

public class A4Q6 {

	public static void main(String[] args) {
		System.out.println(mirrorInv(takeInput()));
	}

	public static int[] takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n = scn.nextInt();

		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			System.out.println("Enter the " + i + "th element of the array");
			a[i] = scn.nextInt();
		}
		return a;
	}

	public static boolean mirrorInv(int[] arr) {
		int[] a = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			a[arr[i]] = i;
		}

		for (int j = 0; j < arr.length; j++) {
			if (a[j] != arr[j])
				return false;
		}
		return true;
	}
}