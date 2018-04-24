package June14;

public class exitPoint {

	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 1, 0, 1, 0 } };
		exitpoint(arr);
	}

	public static void exitpoint(int[][] arr) {
		int dir = 0, row = 0, col = 0;

		while (true) {
			dir = (dir + arr[row][col]) % 4;

			if (dir == 0) { // east
				col++;
				if (col == arr[0].length) {
					System.out.println(row + ", " + (col - 1));
					break;
				}
			} else if (dir == 1) { // south
				row++;
				if (row == arr.length) {
					System.out.println((row - 1) + ", " + (col));
					break;
				}
			} else if (dir == 2) { // west
				col--;
				if (col == -1) {
					System.out.println(row + ", " + (0));
					break;
				}
			} else if (dir == 3) { // north
				row--;
				if (row == -1) {
					System.out.println(0 + ", " + (col));
					break;
				}
			}
		}
	}
}