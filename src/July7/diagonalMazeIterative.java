package July7;

public class diagonalMazeIterative {

	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	public static void main(String[] args) {
		int n = 3;
		startWatch();
		System.out.println(countDMPI(n, n));
		endWatch("diagonalMazeIterative", n);
	}
	
	public static int countDMPI(int er, int ec){
		int[][] strg = new int[er + 1][ec + 1];

		strg[er][ec] = 1;
		for (int row = er; row >= 0; row--) {
			for (int col = ec; col >= 0; col--) {
				if (row == er && col == ec) {
					// Done
				} else if (row == er) {
					strg[row][col] = strg[row][col + 1];
				} else if (col == ec) {
					strg[row][col] = strg[row + 1][col];
				} else {
					strg[row][col] = strg[row + 1][col] + strg[row][col + 1] + strg[row+1][col+1];
				}
			}
		}
		return strg[0][0];
	}
}