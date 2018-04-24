package June21;

public class isPalindromeRec {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 3, 2, 1 };
		System.out.println(palindrome(arr, 0, arr.length - 1));
	}

	public static boolean palindrome(int[] arr, int left, int right) {

		if (arr[left] >= arr[right])
			return true;

		palindrome(arr, left + 1, right - 1);

		if (arr[left] == arr[right])
			return true;
		else
			return false;
	}
}