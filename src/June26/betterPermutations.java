package June26;

public class betterPermutations {

	public static void main(String[] args) {
		getPermutations("abb", "");
	}

	public static void getPermutations(String ques, String ans) {
		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		boolean[] duplicate = new boolean[256];
		for (int i = 0; i < ques.length(); i++) {
			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (duplicate[ch] == false) {
				getPermutations(roq, ans + ch);
				duplicate[ch] = true;
			}
		}
	}
}