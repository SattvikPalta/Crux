package Assignment_4;

public class A4Q17 {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24}, { 31, 32, 33, 34 }, { 41, 42, 43, 44 },
				{ 51, 52, 53, 54 } };
		matrix_display(arr);
		System.out.println();
		System.out.println();
		wavedisplay(arr);
	}

	public static void matrix_display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			System.out.println();
			for (int col = 0; col < arr[0].length; col++)
				System.out.print(arr[row][col] + "\t");
		}
	}

	public static void wavedisplay(int[][] arr) {
		int row = 0, col = 0;
		while (row < arr.length) {
			for (col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			row++;
			for (col = arr[0].length - 1; col >= 0; col--) {
				System.out.print(arr[row][col] + "\t");
			}
			row++;
		}
	}
}
