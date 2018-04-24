package July31;

public class CarClient {

	public static void main(String[] args) {
		Car[] cars = new Car[5];
		cars[0] = new Car("Audi", 100, 1000);
		cars[1] = new Car("Mercedes", 110, 1200);
		cars[2] = new Car("BMW", 140, 1400);
		cars[3] = new Car("Volvo", 120, 800);
		cars[4] = new Car("Porsche", 150, 1600);

		display(cars);
		bubbleSort(cars);
		display(cars);
	}

	public static <T> void display(T[] arr) {
		for (int i = 0; i < arr.length; i++)
			System.out.println(arr[i]);

		System.out.println();
	}

	public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
		int counter = 1;
		while (counter < arr.length) {
			for (int i = 0; i < arr.length - counter; i++) {
				if (arr[i].compareTo(arr[i + 1]) > 0) {
					T temp = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = temp;
				}
			}
			counter++;
		}
	}

}
