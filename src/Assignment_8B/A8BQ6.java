package Assignment_8B;

public class A8BQ6 {

	public static void main(String[] args) {
		boolean[][] board = new boolean[3][3];
		nKnights(1, board, "", 0);
	}

	public static void nKnights(int cellNo, boolean[][] board, String config, int kpsf) {
		if (kpsf == board.length) {
			System.out.println(config);
			return;
		}

		for (int i = cellNo; i <= board.length * board.length; i++) {
			int cr = (i - 1) / board.length;
			int cc = (i + 1) % board.length;

			if (isItSafe(board, cr, cc) == true) {
				board[cr][cc] = true;
				nKnights(i + 1, board, config + "[" + cr + "-" + cc + "]", kpsf + 1);
				board[cr][cc] = false;
			}
		}
	}

	public static boolean isItSafe(boolean[][] board, int cr, int cc) {
		if (cr - 1 >= 0 && cc - 2 >= 0 && board[cr - 1][cc - 2] == true)
			return false;

		if (cr - 2 >= 0 && cc - 1 >= 0 && board[cr - 2][cc - 1] == true)
			return false;

		if (cr - 1 >= 0 && cc + 2 < board.length && board[cr - 1][cc + 2] == true)
			return false;

		if (cr - 2 >= 0 && cc + 1 < board.length && board[cr - 2][cc + 1] == true)
			return false;

		return true;
	}

}
