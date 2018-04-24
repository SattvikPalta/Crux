package June21;

public class maxRecursion {

	public static void main(String[] args) {
		int arr[] = { 11, 22, 33, 44, 55 };
		System.out.println(max(arr, 0));
	}

	public static int max(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return Integer.MIN_VALUE;
		}
		int max = max(arr, vidx + 1);

		if(arr[vidx]>max){
			max=arr[vidx];
		}
		return max;
	}
}
