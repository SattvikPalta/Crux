package June26;

import java.util.ArrayList;

public class PermutationsRec {

	public static void main(String[] args) {
		System.out.println(getPermutations("abc"));
	}

	public static ArrayList<String> getPermutations(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getPermutations(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			for (int i = 0; i <= rs.length(); i++) {
				StringBuilder sb = new StringBuilder(rs);
				sb.insert(i, ch);
				mr.add(sb.toString());
			}
		}
		return mr;
	}
}