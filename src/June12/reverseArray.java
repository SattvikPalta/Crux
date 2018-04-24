package June12;

import java.util.Scanner;

public class reverseArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		reverse(arr);
		display(arr);
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

	public static void reverse(int arr[]) {
		int i = 0, j = arr.length - 1;
		while (i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
}
