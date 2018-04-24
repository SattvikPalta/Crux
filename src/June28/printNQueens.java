package June28;

public class printNQueens {

	public static void main(String[] args) {
		boolean[][] board = new boolean[4][4];
		printNQueens(board, 0, "");
	}

	// qpsf-queens printed so far
	public static void printNQueens(boolean[][] board, int qpsf, String ans) {
		if (qpsf == board.length) {
			System.out.println(ans);
			return;
		}

		int row = qpsf;
		for (int col = 0; col < board[0].length; col++) {
			if (isItSafe(board, row, col) == true) {
				board[row][col] = true;
				printNQueens(board, qpsf + 1, ans + "[" + row + "-" + col + "]");
				board[row][col] = false;
			}
		}
	}

	public static boolean isItSafe(boolean[][] board, int row, int col) {
		int r = row, c = col;

		// check vertical
		while (r >= 0) {
			if (board[r][col] == true) {
				return false;
			}
			r--;
		}

		// check +ve diag
		r = row;
		c = col;
		while (r >= 0 && c < board.length) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c++;
		}

		// check -ve diag
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true) {
				return false;
			}
			r--;
			c--;
		}

		return true;
	}
}