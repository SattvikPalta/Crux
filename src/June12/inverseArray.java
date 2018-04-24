package June12;

public class inverseArray {

	public static void main(String[] args) {
		int[] arr = { 2, 0, 3, 1, 4 };
		display(arr);
		int[] inv = inverse(arr);
		display(inv);
	}

	public static void display(int[] arr) {
		for (int val : arr) {
			System.out.print(val + "\t");
		}
		System.out.println();
	}

	public static int[] inverse(int[] arr) {
		int[] rv = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			rv[arr[i]] = i;
		}
		return rv;
	}
}