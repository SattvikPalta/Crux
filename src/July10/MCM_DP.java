package July10;

public class MCM_DP {

	public static void main(String[] args) {
		int[] dimension = { 10, 20, 30, 40, 50, 60 };
		System.out.println(
				MCM_DP(dimension, 0, dimension.length - 1, new int[dimension.length + 1][dimension.length + 1]));
	}

	public static int MCM_DP(int[] dimension, int si, int ei, int[][] strg) {
		if (si + 1 == ei)
			return 0;

		if (strg.length == 0)
			return strg[si][ei];

		int min = Integer.MAX_VALUE;

		for (int i = si + 1; i < ei; i++) {
			int cost1 = MCM_DP(dimension, si, i, strg);
			int cost2 = MCM_DP(dimension, i, ei, strg);
			int rcm = dimension[si] * dimension[ei] * dimension[i];
			int tc = cost1 + cost2 + rcm;

			if (tc < min)
				min = tc;
		}
		strg[si][ei] = min;
		return min;
	}
}
