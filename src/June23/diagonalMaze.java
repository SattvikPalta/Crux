package June23;

import java.util.ArrayList;

public class diagonalMaze {

	public static void main(String[] args) {
		System.out.println(getMazePathDiag(0, 0, 2, 2));
	}

	public static ArrayList<String> getMazePathDiag(int cr, int cc, int er, int ec) {

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
		ArrayList<String> rr = getMazePathDiag(cr + 1, cc, er, ec);

		for (String rs : rr) {
			mr.add("V" + rs);
		}

		rr = getMazePathDiag(cr, cc + 1, er, ec);

		for (String rs : rr) {
			mr.add("H" + rs);
		}

		rr = getMazePathDiag(cr + 1, cc + 1, er, ec);

		for (String rs : rr) {
			mr.add("D" + rs);

		}
		return mr;
	}
}