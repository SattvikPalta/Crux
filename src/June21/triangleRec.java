package June21;

public class triangleRec {

	public static void main(String[] args) {
		printTri(1, 1, 5);
	}

	public static void printTri(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			System.out.println();
			printTri(row + 1, 1, n);
			return;
		}

		System.out.print("*");
		printTri(row, col + 1, n);
	}

}
