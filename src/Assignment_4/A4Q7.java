package Assignment_4;

import java.util.Scanner;

public class A4Q7 {

	public static void main(String[] args) {
		int[] a = takeInput();
		int[] b = takeInput();
		System.out.println(checkInv(a, b));
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

	public static boolean checkInv(int[] arr1, int[] arr2) {
		int[] a = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			a[arr1[i]] = i;
		}

		for (int k = 0; k < arr1.length; k++) {
			if (a[k] != arr2[k])
				return false;
		}
		return true;
	}
}
