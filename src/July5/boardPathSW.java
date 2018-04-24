package July5;

public class boardPathSW {

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
		int n = 10;
		startWatch();
		System.out.println(countBPISW(n));
		endWatch("countBPISW", n);
	}

	public static int countBPISW(int n) {
		int[] strg = new int[n];

		strg[0] = 1;
		for (int i = n - 1; i >= 0; i--) {
			int newvalue = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];
			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = newvalue;
		}

		return strg[0];
	}
}
