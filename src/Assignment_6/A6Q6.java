package Assignment_6;

public class A6Q6 {

	public static void main(String[] args) {
		int arr[] = { 11, 22, 33, 44, 55 };
		System.out.println(IsSorted(arr, 0));
	}

	public static boolean IsSorted(int[] arr, int vidx) {
		if (vidx == arr.length - 1) {
			return true;
		}

		if (arr[vidx] > arr[vidx + 1]) {
			return false;
		}

		boolean sort = IsSorted(arr, vidx + 1);
		return sort;
	}

}
