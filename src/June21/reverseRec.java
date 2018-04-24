package June21;

public class reverseRec {

	public static void main(String[] args) {
		int arr[] = { 11, 22, 33, 44, 55 };
		reverse(arr, 0);
	}

	public static void reverse(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}
		reverse(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}
}
