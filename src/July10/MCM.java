package July10;

public class MCM {

	public static void main(String[] args) {
		int[] dimension = { 10, 20, 30, 40, 50, 60 };
		System.out.println(MCM(dimension, 0, dimension.length - 1));
	}

	public static int MCM(int[] dimension, int si, int ei) {
		if (si + 1 == ei)
			return 0;

		int min = Integer.MAX_VALUE;

		for (int i = si + 1; i < ei; i++) {
			int cost1 = MCM(dimension, si, i);
			int cost2 = MCM(dimension, i, ei);
			int rcm = dimension[si] * dimension[ei] * dimension[i];
			int tc = cost1 + cost2 + rcm;

			if (tc < min)
				min = tc;
		}
		return min;
	}
}
