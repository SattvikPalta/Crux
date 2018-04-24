package June16;

public class PDIskips {

	public static void main(String[] args) {
		PDIskips(6);
	}

	public static void PDIskips(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 != 0)
			System.out.println("hi " + n);

		PDIskips(n - 1);

		if (n % 2 == 0)
			System.out.println("bye " + n);
	}
}
