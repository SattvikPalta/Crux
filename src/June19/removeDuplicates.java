package June19;

public class removeDuplicates{

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("aaabbcdddee");
		removeDuplicates(sb);
	}

	public static void removeDuplicates(StringBuilder sb) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < sb.length() - 1; i++) {
			if (sb.charAt(i) != sb.charAt(i + 1)) {
				s.append(sb.charAt(i));
			}
		}
		s.append(sb.charAt(sb.length()-1));
		System.out.print(s);
	}
}