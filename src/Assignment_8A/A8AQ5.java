package Assignment_8A;

public class A8AQ5 {
	public static void main(String[] args) {
		TOH(3, "A", "B", "C");
	}

	public static void TOH(int n, String begin, String end, String help) {
		if (n == 0)
			return;

		TOH(n - 1, begin, help, end);
		System.out.println("Move disc [" + n + "] from " + begin + " to " + end);
		TOH(n - 1, help, end, begin);
	}

}
