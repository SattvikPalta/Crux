package Assignment_8B;

public class A8BQ1 {

	public static void main(String[] args) {
		System.out.println(countBoardPath(0, 10));
	}

	public static int countBoardPath(int curr, int end) {
		if (curr == end) {
			return 1;
		}
		if (curr > end) {
			return 0;
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPath(dice + curr, end);
		}
		return count;
	}

}
