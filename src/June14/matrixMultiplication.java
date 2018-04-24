package June14;

import java.util.Scanner;

public class matrixMultiplication {

	public static Scanner scn = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Enter the size of first matrix");
		int m = scn.nextInt();
		int n = scn.nextInt();

		System.out.println("Enter the size of second matrix");
		int p = scn.nextInt();
		int q = scn.nextInt();

		int[][] arr1 = new int[m][n];
		int[][] arr2 = new int[p][q];

		int[][] ans = matrixMultiplication(arr1, arr2);
		display(ans);
	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] matrixMultiplication(int[][] arr1, int[][] arr2) {
		int m = arr1.length, n = arr1[0].length;
		int p = arr2.length, q = arr2[0].length;
		int[][] sum = new int[m][q];

		if (n != p) {
			System.out.println("Multiplication not possible");
			return sum;

		} else {
			System.out.println("Enter the elements of first array");
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					arr1[i][j] = scn.nextInt();
				}
			}

			System.out.println("Enter the elements of second array");
			for (int i = 0; i < p; i++) {
				for (int j = 0; j < q; j++) {
					arr2[i][j] = scn.nextInt();
				}
			}
			
			int sum1 = 0;

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < q; j++) {
					sum1 = 0;
					for (int k = 0; k < n; k++) {
						sum1 = sum1 + arr1[i][k] * arr2[k][j];
					}
					sum[i][j] = sum1;
				}
			}
			
			return sum;
		}
	}
}
