package June21;

public class findRec {

	public static void main(String[] args) {
		int arr[] = { 11, 22, 33, 44, 55 };
		System.out.println(find(arr, 0, 55));
	}

	public static boolean find(int[] arr, int vidx, int data) {
		if (vidx == arr.length) {
			return false;
		}

		if (arr[vidx] == data) {
			return true;
		}

		boolean find = find(arr, vidx + 1, data);
		return find;

	}
}