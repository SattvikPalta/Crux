package Assignment_4;

import java.util.Scanner;

public class A4Q12 {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		display(arr);
		int num = scn.nextInt();
		sumPair(arr, num);
	}

	public static void sumPair(int[] arr, int num) {
		sort(arr);
		display(arr);
		System.out.println("\n");
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] != arr[j]) {
					if (num == arr[i] + arr[j]) {
						System.out.println(arr[i] + " and " + arr[j]);
					}
				}
			}
		}
	}

	public static void sort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static int[] takeInput() {
		int n = scn.nextInt();
		int[] rv = new int[n];
		for (int i = 0; i < n; i++) {
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