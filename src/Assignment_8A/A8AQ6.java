package Assignment_8A;

import java.util.ArrayList;

import java.util.Scanner;

public class A8AQ6 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter size of the array");
		int n = scn.nextInt();

		System.out.println("Enter array elements");
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

//		System.out.println(countSp(arr, 0, 0, 0, "", "", 0));
//		System.out.println(split(arr, 0, 0, 0, "", ""));
	}

	public static int countSp(int[] arr, int vidx, int sg1, int sg2, String g1, String g2, int count) {
		if (arr.length == vidx) {
			if (sg1 == sg2) {
				count++;
			}
			return count;
		}

		int a = countSp(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2, count);
		int b = countSp(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx], count);
		return a + b;
	}

	public static ArrayList<String> split(int[] arr, int vidx, int sg1, int sg2, String g1, String g2) {

		if (vidx == arr.length) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> mr1 = new ArrayList<>();
		ArrayList<String> mr2 = new ArrayList<>();

		ArrayList<String> rr = split(arr, vidx + 1, sg1 + arr[vidx], sg2, g1 + " " + arr[vidx], g2);
		for (String rs : rr) {
			mr1.add(g1);
		}
		ArrayList<String> rr1 = split(arr, vidx + 1, sg1, sg2 + arr[vidx], g1, g2 + " " + arr[vidx]);
		for (String rs : rr1) {
			mr2.add(g2);
		}
		if (sg1 == sg2 && vidx == arr.length) {
			mr.addAll(mr1);
			mr.addAll(mr2);
		}
		return mr;
	}

}
