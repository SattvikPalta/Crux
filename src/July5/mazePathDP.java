package July5;

public class mazePathDP {

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
		int n = 16;
		startWatch();
		System.out.println(countMazePath(0, 0, n, n, new int[n + 1][n + 1]));
		endWatch("countMazePath", n);
	}

	public static int countMazePath(int cr, int cc, int er, int ec, int[][] strg) {
		if (cr == er && cc == ec) {
			return 1;
		}

		if (cr > er || cc > ec) {
			return 0;
		}

		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = countMazePath(cr + 1, cc, er, ec, strg);
		int cv = countMazePath(cr, cc + 1, er, ec, strg);
		int count = ch + cv;

		strg[cr][cc] = count;
		return count;
	}
}
