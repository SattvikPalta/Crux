package June28;

public class betterMazePath {

	public static void main(String[] args) {
		mazePath(0, 0, 2, 2, "");
	}

	public static void mazePath(int cr, int cc, int er, int ec, String ans) {
		if (cr == er && cc == ec) {
			System.out.println(ans);
			return;
		}

		if (cr > er || cc > ec) {
			return;
		}

		mazePath(cr + 1, cc, er, ec, ans + "H");
		mazePath(cr, cc + 1, er, ec, ans + "V");
	}
}
