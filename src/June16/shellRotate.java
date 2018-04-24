package June16;

public class shellRotate {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15, 16 },
						{ 21, 22, 23, 24, 25, 26 },
						{ 31, 32, 33, 34, 35, 36 },
						{ 41, 42, 43, 44, 45, 46 },
						{ 51, 52, 53, 54, 55, 56 },
						{ 61, 62, 63, 64, 65, 66 } };
		
		shellRotate(arr, 2, 2);
		display(arr);
	}

	public static void display(int[][] arr) {
		for (int row = 0; row < arr.length; row++) {
			for (int col = 0; col < arr[0].length; col++) {
				System.out.print(arr[row][col] + "\t");
			}
			System.out.println();
		}
	}

	public static int[] rotate(int[] arr, int k) {
		int[] rv = new int[arr.length];
		int i = 0;
		int t = k;
		for (i = 0; i < t; i++) {
			rv[i] = arr[arr.length - k];
			k--;
		}
		for (int j = 0; i < arr.length; i++, j++) {
			rv[i] = arr[j];
		}
		return rv;
	}

	public static void shellRotate(int[][] arr, int k, int r) {
		int rmin = k - 1, cmin = k - 1, rmax = arr.length - k, cmax = arr[0].length - k;
		int counter = 0;
		int[] oned = new int[2 * (rmax - rmin + cmax - cmin)];

		// left wall
		for (int row = rmin; row <= rmax; row++) {
			oned[counter] = arr[row][cmin];
			counter++;
		}
		cmin++;

		// bottom wall
		for (int col = cmin; col <= cmax; col++) {
			oned[counter] = arr[rmax][col];
			counter++;
		}
		rmax--;

		// right wall
		for (int row = rmax; row >= rmin; row--) {
			oned[counter] = arr[row][cmax];
			counter++;
		}
		cmax--;

		// top wall
		for (int col = cmax; col >= cmin; col--) {
			oned[counter] = arr[rmin][col];
			counter++;
		}
		rmin++;

		int[] rotoned = rotate(oned, r);
		rmin = k - 1;
		cmin = k - 1;
		rmax = arr.length - k;
		cmax = arr[0].length - k;
		counter = 0;

		// left wall
		for (int row = rmin; row <= rmax; row++) {
			arr[row][cmin] = rotoned[counter];
			counter++;
		}
		cmin++;

		// bottom wall
		for (int col = cmin; col <= cmax; col++) {
			arr[rmax][col] = rotoned[counter];
			counter++;
		}
		rmax--;

		// right wall
		for (int row = rmax; row >= rmin; row--) {
			arr[row][cmax] = rotoned[counter];
			counter++;
		}
		cmax--;

		// top wall
		for (int col = cmax; col >= cmin; col--) {
			arr[rmin][col] = rotoned[counter];
			counter++;
		}
		rmin++;
	}
}
