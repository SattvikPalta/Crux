package June28;

import java.util.Scanner;

public class splitArray {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n = scn.nextInt();

		System.out.println("Enter array elements");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		printSplitArray(arr, 0, 0, 0, "", "");
	}

	public static void printSplitArray(int[] arr, int vidx, int sg1, int sg2, String g1, String g2) {
		if (vidx == arr.length) {
			if (sg1 == sg2)
				System.out.println(g1 + "\t" + g2);

			return;
		}

		printSplitArray(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2);
		printSplitArray(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx]);
	}
}
