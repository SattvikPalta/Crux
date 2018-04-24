package July7;

import java.util.Arrays;

public class diagonalMazeSW {

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
		System.out.println(countMPI(n, n));
		endWatch("diagonalMazeSW", n);
	}

	public static int countMPI(int er, int ec) {
		int[] window = new int[ec + 1];
		Arrays.fill(window, 1);

		for (int row = er - 1; row >= 0; row--) {
			int temp = window[ec];
			for (int col = ec - 1; col >= 0; col--) {
				int nv = window[col] + window[col + 1] + temp;
				temp = window[col];
				window[col] = nv;
			}
		}
		return window[0];
	}
}
