package June28;

public class betterBoardPath {

	public static void main(String[] args) {
		boardPaths(0, 10, "");
		System.out.println();
		System.out.println(tester);
	}

	public static int tester = 0;

	public static void boardPaths(int curr, int end, String ans) {
		if (curr == end) {
			System.out.println(ans);
			tester++;
			return;
		}

		else if (curr > end) {
			return;
		}

		for (int dice = 1; dice <= 6; dice++) {
			boardPaths(curr + dice, end, ans + dice);
		}
	}
}