package Assignment_8B;

import java.util.ArrayList;

public class A8BQ4 {

	public static void main(String[] args) {
//		System.out.println(countMazePathDiagonal2(0, 0, 2, 2, 0));
//		System.out.println(mazePathDiag2(0, 0, 2, 2));
//		mazePathDiagonal2(0, 0, 2, 2, "");
	}

	public static int countMazePathDiagonal2(int cr, int cc, int er, int ec, int count) {
		if (cr == er && cc == ec) {
			return count + 1;
		}

		if (cr > er || cc > ec) {
			return count;
		}

		int a = countMazePathDiagonal2(cr + 1, cc, er, ec, count);
		int b = countMazePathDiagonal2(cr, cc + 1, er, ec, count);
		int c = 0;
		if (cr == cc || cr + cc == ec) {
			c = countMazePathDiagonal2(cr + 1, cc + 1, er, ec, count);
			return a + b + c;
		}
		return a + b + c;
	}

	public static ArrayList<String> mazePathDiag2(int cr, int cc, int er, int ec) {

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
		ArrayList<String> rr = mazePathDiag2(cr + 1, cc, er, ec);

		for (String rs : rr) {
			mr.add("V" + rs);
		}

		rr = mazePathDiag2(cr, cc + 1, er, ec);

		for (String rs : rr) {
			mr.add("H" + rs);
		}

		if (cr == cc || cr + cc == ec) {
			rr = mazePathDiag2(cr + 1, cc + 1, er, ec);

			for (String rs : rr) {
				mr.add("D" + rs);
			}
		}
		return mr;
	}

	public static void mazePathDiagonal2(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		mazePathDiagonal2(cr + 1, cc, er, ec, ans + "H");
		mazePathDiagonal2(cr, cc + 1, er, ec, ans + "V");
		if (cr == cc || cr + cc == ec) {
			mazePathDiagonal2(cr + 1, cc + 1, er, ec, ans + "D");
		}
	}

}
