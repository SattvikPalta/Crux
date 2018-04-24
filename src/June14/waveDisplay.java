package June14;

public class waveDisplay {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14 }, { 21, 22, 23, 24 }, { 31, 32, 33, 34 }, { 41, 42, 43, 44 },
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
		while (col < arr[0].length) {
			for (row = 0; row < arr.length; row++) {
				System.out.print(arr[row][col] + "\t");
			}

			col++;

			for (row = arr.length - 1; row >= 0; row--) {
				System.out.print(arr[row][col] + "\t");
			}

			col++;
		}
	}
}