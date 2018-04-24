package June23;

import java.util.ArrayList;

public class boardPaths {

	public static void main(String[] args) {
		System.out.println(getBoardPaths(0, 10));
	}

	public static ArrayList<String> getBoardPaths(int curr, int end) {

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		else if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int dice = 1; dice <= 6; dice++) {
			ArrayList<String> rr = getBoardPaths(curr + dice, end);
			for (String rs : rr) {
				mr.add(dice + rs);
			}
		}
		return mr;
	}
}
