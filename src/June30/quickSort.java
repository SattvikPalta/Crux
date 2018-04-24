package June30;

import java.util.Scanner;

public class quickSort {
	
	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	public static void main(String[] args) {
		int[] arr = takeInput();
		quickSort(arr, 0, arr.length - 1);
		display(arr);
	}

	public static int[] takeInput() {
		Scanner scn = new Scanner(System.in);
		System.out.print("Enter the size of array: ");
		int n = scn.nextInt();

		int[] rv = new int[n];
		for (int i = 0; i < rv.length; i++) {
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

	public static void quickSort(int[] arr, int low, int high) {
		if (low >= high)
			return;

		int mid = (low + high) / 2;
		int pivot = arr[mid];
		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			while (arr[left] < pivot)
				left++;

			while (arr[right] > pivot)
				right--;

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}
		}
		quickSort(arr, low, right);
		quickSort(arr, left, high);
	}
}