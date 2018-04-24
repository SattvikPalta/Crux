package July5;

public class boardPathIterative {

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
		System.out.println(countBPI(n));
		endWatch("countBPI", n);
	}

	public static int countBPI(int n) {
		int[] strg = new int[n + 6];

		strg[n] = 1;
		for (int i = n-1; i >= 0; i--) 
			for (int j = 1; j <= 6; j++)
				strg[i] = strg[i] + strg[i + j];

		return strg[0];
	}
}
