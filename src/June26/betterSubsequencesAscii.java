package June26;

public class betterSubsequencesAscii {

	public static void main(String[] args) {
		printSubsequencesAscii("abc", "");
	}

	public static void printSubsequencesAscii(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		char ch = ques.charAt(0);
		String roq = ques.substring(1);

		printSubsequencesAscii(roq, ans + "");
		printSubsequencesAscii(roq, ans + ch);
		printSubsequencesAscii(roq, ans + (int) ch);
	}
}
