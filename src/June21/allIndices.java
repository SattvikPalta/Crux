package June21;

public class allIndices {

	public static void main(String[] args) {
		int[] arr = { 3, 7, 4, 7, 7, 6, 2, 8, 7, 7 };
		int a[] = allIndices(arr, 0, 7, 0);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

	public static int[] allIndices(int[] arr, int vidx, int data, int csf) {
		if (vidx == arr.length) {
			return new int[csf];
		}

		if (arr[vidx] == data) {
			int[] rr = allIndices(arr, vidx + 1, data, csf + 1);
			rr[csf] = vidx;
			return rr;
		}
		
		else {
			int[] rr = allIndices(arr, vidx + 1, data, csf);
			return rr;
		}
	}
}
