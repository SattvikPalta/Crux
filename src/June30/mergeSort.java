package June30;

import java.util.Scanner;

public class mergeSort {

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(mergeSort(arr, 0, arr.length - 1));
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

	public static int[] mergeSortedArrays(int[] one, int[] two) {
		int[] merge = new int[one.length + two.length];

		int i = 0;
		int j = 0;
		int k = 0;

		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				merge[k] = one[i];
				i++;
				k++;
			} else {
				merge[k] = two[j];
				j++;
				k++;
			}
		}

		while (i < one.length) {
			merge[k] = one[i];
			i++;
			k++;
		}

		while (j < two.length) {
			merge[k] = two[j];
			j++;
			k++;
		}

		return merge;
	}

	public static int[] mergeSort(int[] arr, int low, int high) {
		if (low == high) {
			int[] br = new int[1];
			br[0] = arr[low];
			return br;
		}

		int mid = (low + high) / 2;

		int[] mergeFirstHalf = mergeSort(arr, low, mid);
		int[] mergeSecondHalf = mergeSort(arr, mid + 1, high);

		return mergeSortedArrays(mergeFirstHalf, mergeSecondHalf);
	}
}
