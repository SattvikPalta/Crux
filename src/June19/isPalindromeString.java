package June19;

public class isPalindromeString {

	public static void main(String[] args) {
		String s = "nitin";
		System.out.println(palindrome(s));
	}

	public static boolean palindrome(String s) {
		int end = s.length() - 1;
		for (int begin = 0; begin < s.length() / 2; begin++) {
			if (s.charAt(begin) != s.charAt(end)) {
				return false;
			}
			end--;
		}
		return true;
	}
}
