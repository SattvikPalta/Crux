package Assignment_8B;

public class A8BQ3 {

	public static void main(String[] args) {
		System.out.println(countMazePathDiag(0, 0, 2, 2, 0));
	}

	public static int countMazePathDiag(int cr, int cc, int er, int ec, int count) {
		if (cr == er && cc == ec) {
			return count + 1;
		}

		if (cr > er || cc > ec) {
			return count;
		}

		return countMazePathDiag(cr + 1, cc, er, ec, count) + countMazePathDiag(cr, cc + 1, er, ec, count)
				+ countMazePathDiag(cr + 1, cc + 1, er, ec, count);
	}

}
