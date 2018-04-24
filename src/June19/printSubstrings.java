package June19;

public class printSubstrings {

	public static void main(String[] args) {
		String s = "hello";
		printSubstrings(s);
	}

	public static void printSubstrings(String s) {
		for (int begin = 0; begin < s.length(); begin++) {
			for (int end = begin; end < s.length(); end++) {
				System.out.println(s.substring(begin, end + 1));
			}
		}
	}
}
