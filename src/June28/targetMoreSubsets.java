package June28;

public class targetMoreSubsets {

	public static void main(String[] args) {
		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80 };
		printTargetSS(arr, 0, 80, "");
	}

	public static void printTargetSS(int[] arr, int vidx, int target, String asf) {
		if (vidx == arr.length) {
			if (target < 0)
				System.out.println(asf);
			return;
		}

		printTargetSS(arr, vidx + 1, target, asf); // no
		printTargetSS(arr, vidx + 1, target - arr[vidx], asf + "\t" + arr[vidx]); // yes
	}
}