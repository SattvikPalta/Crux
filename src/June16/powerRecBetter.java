package June16;

public class powerRecBetter {

	public static void main(String[] args) {
		System.out.println(powerbetter(2, 5));
	}

	public static int powerbetter(int x, int n) {
		if (n == 0) {
			return 1;
		}

		int xpnb2 = powerbetter(x, n / 2);
		int xpn = xpnb2 * xpnb2;

		if (n % 2 == 1) {
			xpn = xpn * x;
		}
		
		return xpn;
	}
}