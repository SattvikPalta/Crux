package July7;

public class LCSrec {

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
		System.out.println(LCS("aefbg", "adefg"));
		endWatch("LCSrec");
	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return 1 + LCS(ros1, ros2);
		} else {
			int f1 = LCS(s1, ros2);
			int f2 = LCS(ros1, s2);

			return Math.max(f1, f2);
		}
	}
}