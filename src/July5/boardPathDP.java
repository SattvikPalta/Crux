package July5;

public class boardPathDP {
	
	public static long start = 0;
	public static long end = 0;

	public static void startWatch() {
		start = System.currentTimeMillis();
	}

	public static void endWatch(String algo, int n) {
		end = System.currentTimeMillis();
		System.out.println(algo + " took " + (end - start) + " ms for n = " + n);
	}

	
	public static void main(String[] args) {
		int n = 30;
		startWatch();
		System.out.println(countBoardPaths(0, n, new int[n+1]));
		endWatch("boardPathDP",n);
	}

	public static int countBoardPaths(int curr, int end, int[] strg) {
		if (curr == end) {
			return 1;
		}

		else if (curr > end) {
			return 0;
		}
		
		if(strg[curr] != 0){
			return strg[curr];
		}

		int count = 0;
		for (int dice = 1; dice <= 6; dice++) {
			count += countBoardPaths(curr + dice, end, strg);
		}
		
		strg[curr] = count;
		return count;
	}
}
