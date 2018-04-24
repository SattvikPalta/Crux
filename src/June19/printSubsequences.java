package June19;

public class printSubsequences {

	public static void main(String[] args) {
		String s = "abcd";
		printSubsequences(s);
	}

	public static void printSubsequences(String s) {
		StringBuilder sb = new StringBuilder();
		int counter = (int) Math.pow(2, s.length());
		for (int i = 0; i < counter; i++) {
			int temp = i;

			for (int j = 0; j < s.length(); j++) {
				int rem = temp % 2;
				if (rem == 1) {
					sb.append(s.charAt(j));
				}
				temp = temp / 2;
			}
			System.out.print("[" + sb + "]");
			sb.delete(0, s.length());
		}
		System.out.println();
	}
}