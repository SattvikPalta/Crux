package June21;

public class lastIndex {

	public static void main(String[] args) {
		int arr[] = { 11, 22, 22, 44, 22 };
		System.out.println(lastIndex(arr, 0, 22));
	}

	public static int lastIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		int lastIdx = lastIndex(arr, vidx + 1, data);

		if (arr[vidx] == data && lastIdx == -1) {
			return vidx + 1;
		}

		return lastIdx;
	}
}
