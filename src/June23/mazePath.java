package June23;

import java.util.ArrayList;

public class mazePath {

	public static void main(String[] args) {
		System.out.println(getMazePath(0, 0, 2, 2));
	}

	public static ArrayList<String> getMazePath(int cr, int cc, int er, int ec) {

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
		ArrayList<String> rr = getMazePath(cr + 1, cc, er, ec);

		for (String rs : rr) {
			mr.add("V" + rs);
		}

		rr = getMazePath(cr, cc + 1, er, ec);

		for (String rs : rr) {
			mr.add("H" + rs);
		}
		return mr;
	}
}