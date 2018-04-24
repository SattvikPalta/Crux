package June12;

import java.util.Scanner;

public class rotateArray {
	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		int[] arr = takeInput();
		int[] rot = rotate(arr, 2);
		display(rot);
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
			System.out.print(val + "\t");
		}
		System.out.println();
	}

	public static int[] rotate(int[] arr, int k) {
		int[] rv = new int[arr.length];
		int i = 0;
		int t = k;
		for (i = 0; i < t; i++) {
			rv[i] = arr[arr.length - k];
			k--;
		}
		for (int j = 0; i < arr.length; i++, j++) {
			rv[i] = arr[j];
		}
		
		return rv;
	}

}
