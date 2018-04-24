package July7;

public class editDistance {

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
		System.out.println(editDistance("abcde", "a"));
		endWatch("editDistance");
	}

	public static int editDistance(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			if (s1.length() != 0)
				return s1.length();
			else if (s2.length() == 0)
				return s2.length();
			return 0;
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		if (ch1 == ch2) {
			return editDistance(ros1, ros2);
		} else {
			int finsert = 1 + editDistance(ros1, s2);
//			int freplace = 1 + editDistance(ros1, ros2);
			int fremove = 1 + editDistance(s1, ros2);

			return Math.min(finsert, fremove);
		}
	}
}
