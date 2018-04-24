package June21;

public class firstIndex {

	public static void main(String[] args) {
		int arr[] = { 11, 44, 22, 44, 44 };
		System.out.println(firstIndex(arr, 0, 44));
	}

	public static int firstIndex(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return -1;
		}

		if (arr[vidx] == data) {
			return vidx;
		}
		
		int firstIdx = firstIndex(arr, vidx + 1, data);
		return firstIdx;
	}
}
