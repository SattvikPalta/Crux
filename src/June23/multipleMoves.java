package June23;

import java.util.ArrayList;

public class multipleMoves {

	public static void main(String[] args) {
		System.out.println(multiMoves(0, 0, 2, 2));
	}

	public static ArrayList<String> multiMoves(int cr, int cc, int er, int ec) {

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= er; i++) {
			ArrayList<String> rr1 = multiMoves(cr + i, cc, er, ec);
			for (String rs : rr1) {
				mr.add("V" + i + rs);
			}
		}

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rr2 = multiMoves(cr, cc + i, er, ec);
			for (String rs : rr2) {
				mr.add("H" + i + rs);
			}
		}

		for (int i = 1; i <= er || i <= ec; i++) {
			ArrayList<String> rr3 = multiMoves(cr + i, cc + i, er, ec);
			for (String rs : rr3) {
				mr.add("D" + i + rs);
			}
		}

		return mr;
	}
}
