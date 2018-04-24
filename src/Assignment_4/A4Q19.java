package Assignment_4;

public class A4Q19 {

	public static void main(String[] args) {
		int[][] arr = { { 11, 12, 13, 14, 15 }, { 21, 22, 23, 24, 25 }, { 31, 32, 33, 34, 35 },
				{ 41, 42, 43, 44, 45 } };

		matrixdisplay(arr);
		spiraldisplay(arr);
	}

	public static void matrixdisplay(int[][] arr) {

		for (int row = 0; row < arr.length; row++) {
			System.out.println();
			for (int col = 0; col < arr[0].length; col++)
				System.out.print(arr[row][col] + "\t");
		}
		System.out.println("\n");
	}

	public static void spiraldisplay(int[][] arr) {

		int dir = 0, rmin = 0, cmin = 0, rmax = arr.length - 1, cmax = arr[0].length - 1, row = rmin, col = cmin;
		int counter = 1;
		int TNE = arr.length * arr[0].length;

		while (counter <= TNE) {
			System.out.print(arr[row][col] + "\t");
			counter++;

			if (dir == 0) {
				col++;
				if (col >= cmax) {
					if (col > cmax) {
						col = cmax;
						row--;
					}
					dir++;
				}

			} else if (dir == 1) {
				row++;
				if (row >= rmax) {
					if (row > rmax) {
						row = rmax;
						col++;
					}
					dir++;
				}

			} else if (dir == 2) {
				col--;
				if (col <= cmin) {
					if (col < cmin) {
						col = cmin;
						col++;
					}
					dir++;
				}

			} else if (dir == 3) {
				row--;
				if (row <= rmin) {
					if (row < rmin) {
						row = rmin;
						row++;
					}
					dir = 0;

					rmin++;
					cmin++;
					rmax--;
					cmax--;

					row = rmin;
					col = cmin;
				}
			}
		}
	}
}
