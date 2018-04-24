package Assignment_6;

import java.util.Scanner;

public class A6Q14 {

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		bubbleSort(arr, 0, 0);
		System.out.println();
		display(arr);
	}

	// cse - count of sorted elements
	public static void bubbleSort(int[] arr, int vidx, int cse) {
		if (cse == arr.length - 1) {
			return;
		}

		if (vidx == arr.length - 1 - cse) {
			bubbleSort(arr, 0, cse + 1);
			return;
		}

		if (arr[vidx] > arr[vidx + 1]) {
			int temp = arr[vidx];
			arr[vidx] = arr[vidx + 1];
			arr[vidx + 1] = temp;
		}

		bubbleSort(arr, vidx + 1, cse);
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
		for (int value : arr) {
			System.out.print(value + " ");
		}
	}
}