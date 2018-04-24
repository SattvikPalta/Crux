package June21;

public class invertedTriangleRec {

	public static void main(String[] args) {
		printInvTri(1, 1, 5);
	}

	public static void printInvTri(int row, int col, int n) {
		if (row > n) {
			return;
		}

		if (col > row) {
			printInvTri(row + 1, 1, n);
			System.out.println();

			return;
		}

		printInvTri(row, col + 1, n);
		System.out.print("*");

	}
}
