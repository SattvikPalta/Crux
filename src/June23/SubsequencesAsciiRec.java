package June23;

import java.util.ArrayList;

public class SubsequencesAsciiRec {

	public static void main(String[] args) {
		System.out.println(printSubsequencesAscii("abc"));
	}

	public static ArrayList<String> printSubsequencesAscii(String str) {
		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		
		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = printSubsequencesAscii(ros);
		ArrayList<String> mr = new ArrayList<>();

		for (String rs : rr) {
			mr.add(rs);
			mr.add(ch + rs);
			mr.add((int)ch + rs);
		}
		return mr;
	}
}
