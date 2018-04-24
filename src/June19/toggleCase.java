package June19;

public class toggleCase {

	public static void main(String[] args) {
		System.out.println(toggleCase("SaTtViK"));
	}

	public static String toggleCase(String s) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			char nch = '\0';

			if (ch >= 'a' && ch <= 'z') {
				nch = (char) (ch - 'a' + 'A');
			} else if (ch >= 'A' && ch <= 'Z') {
				nch = (char) (ch - 'A' + 'a');
			}

			sb.append(nch);
		}

		return sb.toString();
	}
}