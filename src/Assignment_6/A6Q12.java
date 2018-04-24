package Assignment_6;

import java.util.Scanner;

public class A6Q12 {

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		int[] arr1 = reverseArray(arr, 0, 0);
		System.out.println();
		display(arr1);
	}

	public static int[] reverseArray(int[] arr, int vidx, int rvidx) {
		if (vidx == arr.length)
			return new int[vidx];

		int[] rr = reverseArray(arr, vidx + 1, rvidx + 1);
		rr[rvidx] = arr[arr.length - 1 - vidx];
		return rr;
	}

	public static int[] takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter the value for " + i + "th element");
			rv[i] = scn.nextInt();
		}
		return rv;
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
	}
}