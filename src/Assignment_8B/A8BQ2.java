package Assignment_8B;

public class A8BQ2 {

	public static void main(String[] args) {
		System.out.println(mazePath(0, 0, 2, 2, 0));
	}

	public static int mazePath(int cr, int cc, int er, int ec, int count) {
		if (cr == er && cc == ec) {
			return count + 1;
		}

		if (cr > er || cc > ec) {
			return count;
		}

		return mazePath(cr + 1, cc, er, ec, count) + mazePath(cr, cc + 1, er, ec, count);
	}

}
