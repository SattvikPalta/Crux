package Assignment_6;

public class A6Q4 {

	public static void main(String[] args) {
		triangle(0, 0, 6, 1);
	}

	public static void triangle(int row, int col, int n, int val) {
		if (row > n)
			return;

		if (col > row) {
			System.out.println();
			triangle(row + 1, 0, n, 1);
			return;
		}

		System.out.print(val + " ");
		val = (val * (row - col)) / (col + 1);
		triangle(row, col + 1, n, val);
	}
}
