package Assignment_8B;

import java.util.Arrays;
import java.util.HashMap;

public class A8BQ7 {

	public static void main(String[] args) {
		int n = 15;
		boolean[] arr = SieveOfEratosthenes(n);

		HashMap<Integer, Integer> ladders = new HashMap<>();
		int left = 0;
		int right = 0;

		while (left < right) {
			while (arr[left] == false)
				left++;

			while (arr[right] == false)
				right--;

			if (left < right) {
				ladders.put(left, right);
				left++;
				right--;
			}
		}

		printPath(0, n, "", ladders);
	}

	public static boolean[] SieveOfEratosthenes(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = primes[1] = false;
		for (int table = 2; table * table <= n; table++) {
			if (primes[table] == false)
				continue;

			for (int mul = 2; table * mul <= n; mul++)
				primes[table * mul] = false;
		}

		return primes;
	}

	public static void printPath(int curr, int end, String psf, HashMap<Integer, Integer> ladders) {
		if (curr == end) {
			System.out.println(psf);
			return;
		}

		if (curr > end)
			return;

		if (ladders.containsKey(curr))
			printPath(ladders.get(curr), end, psf + "L[" + curr + "->" + ladders.get(curr) + "]", ladders);
		else
			for (int dice = 1; dice <= 6; dice++)
				printPath(curr + dice, end, psf + "D" + dice, ladders);
	}
}
