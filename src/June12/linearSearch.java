package June12;

import java.util.Scanner;

public class linearSearch {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.println(linearsearch(arr, 5));
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
		for (int val : arr) {
			System.out.println(val + "\t");
		}
		
		System.out.println();
	}

	public static int linearsearch(int[] arr, int data) {

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == data)
				return i;
		}
		
		return -1;
	}
}