package Assignment_6;

import java.util.Scanner;

public class A6Q15 {

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		selectionSort(arr, 0, 0);
		System.out.println();
		display(arr);
	}

	// cse - count of sorted elements
	public static void selectionSort(int[] arr, int vidx, int cse) {
		if (cse == arr.length - 1) {
			return;
		}

		if (vidx == arr.length - 1 - cse) {
			selectionSort(arr, 0, cse + 1);
			return;
		}

		selectionSort(arr, vidx + 1, cse);

		if (arr[vidx + 1] < arr[vidx]) {
			int temp = arr[vidx + 1];
			arr[vidx + 1] = arr[vidx];
			arr[vidx] = temp;
		}
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