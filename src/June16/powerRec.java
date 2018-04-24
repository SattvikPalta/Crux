package June16;

public class powerRec {

	public static void main(String[] args) {
		System.out.println(power(2, 5));
	}

	public static int power(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnm1 = power(x, n - 1);
		int xpn = xpnm1 * x;

		return xpn;
	}
}
