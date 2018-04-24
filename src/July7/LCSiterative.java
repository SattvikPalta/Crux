package July7;

public class LCSiterative {

	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms");
	}

	public static void main(String[] args) {
		startWatch();
		System.out.println(I_LCS("aefbg", "adefg"));
		endWatch("LCSiterative");
	}

	public static int I_LCS(String s1, String s2) {
		int[][] strg = new int[s2.length() + 1][s1.length() + 1];

		for (int i = s2.length() - 1; i >= 0; i--) {
			for (int j = s1.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = 1 + strg[i + 1][j + 1];
				} else {
					int f1 = strg[i][j + 1];
					int f2 = strg[i + 1][j];
					strg[i][j] = Math.max(f1, f2);
				}
			}
		}
		return strg[0][0];
	}
}