package June12;

import java.util.Scanner;

public class maxArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.println(max(arr));
	}

	public static int[] takeInput() {
		System.out.println("Enter the size of array");
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
			System.out.println("Enter the value for " + i + "th element");
			rv[i] = scn.nextInt();
		}

		return rv;
	}

	public static void display(int[] arr) {
		for (int val : arr)
			System.out.println(val + "\t");

		System.out.println();
	}

	public static int max(int[] arr) {
		int max = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		
		return max;
	}
}