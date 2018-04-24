package Assignment_8A;

public class A8AQ8 {

	public static void main(String[] args) {
		lexicographicalOrder(1, 1000);
	}

	public static void lexicographicalOrder(int curr, int max) {
		System.out.println(curr);
		int i = 0;
		while (i <= 9) {
			if (curr * 10 + i <= max)
				lexicographicalOrder(curr * 10 + i, max);
			i++;
		}

		if (curr < 9)
			lexicographicalOrder(curr + 1, max);
	}
}
