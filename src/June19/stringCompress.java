package June19;

public class stringCompress {

	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder("aaabbccdee");
		stringCompress(sb);
	}

	public static void stringCompress(StringBuilder sb) {
		StringBuilder s = new StringBuilder();
		int count = 1;
		for (int i = 0; i < sb.length() - 1; i++) {
			if (sb.charAt(i) != sb.charAt(i + 1)) {
				s.append(sb.charAt(i));
				if (count > 1) {
					s.append(count);
				}
				count = 1;
			} else if (sb.charAt(i) == sb.charAt(i + 1)) {
				count++;
			}
		}
		s.append(sb.charAt(sb.length() - 1));
		s.append(count);
		System.out.print(s);
	}
}