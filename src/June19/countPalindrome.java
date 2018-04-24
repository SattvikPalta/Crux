package June19;

public class countPalindrome {

	public static void main(String[] args) {
		String s = "nitin";
		System.out.println(countPalindrome(s));
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

	public static int countPalindrome(String s) {
		int count = 0;
		for (int begin = 0; begin < s.length(); begin++) {
			for (int end = begin + 1; end <= s.length(); end++) {
				String sub = s.substring(begin, end);
				if (palindrome(sub)) {
					count++;
				}
			}
		}
		return count;
	}
}
