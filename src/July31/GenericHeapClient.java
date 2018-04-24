package July31;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class GenericHeapClient {

	public static void main(String[] args) {
		// Car[] cars = new Car[7];
		// cars[0] = new Car("Audi", 100, 1000);
		// cars[1] = new Car("Mercedes", 110, 1200);
		// cars[2] = new Car("BMW", 140, 1400);
		// cars[3] = new Car("Volvo", 120, 800);
		// cars[4] = new Car("Porsche", 150, 1600);
		// cars[5] = new Car("Volkswagon", 80, 600);
		// cars[6] = new Car("Skoda", 70, 500);
		//
		// GenericHeap<Car> heap = new GenericHeap<>(Car.RevNameComp);
		// for (Car car : cars)
		// heap.add(car);
		//
		// while (heap.isEmpty() != true)
		// System.out.println(heap.removeHP());

		// ArrayList<Integer> one = new ArrayList<>(Arrays.asList(10, 15, 20,
		// 25));
		// ArrayList<Integer> two = new ArrayList<>(Arrays.asList(9, 18, 24,
		// 27));
		// ArrayList<Integer> three = new ArrayList<>(Arrays.asList(5, 7, 28,
		// 40));
		// ArrayList<Integer> four = new ArrayList<>(Arrays.asList(17, 19, 21,
		// 28));
		//
		// ArrayList<ArrayList<Integer>> lists = new
		// ArrayList<>(Arrays.asList(one, two, three, four));
		//
		// System.out.println(mergeKLists(lists));

		ArrayList<Integer> lists = new ArrayList<>(Arrays.asList(20, 40, 10, 80, 50, 90, 30, 70, 60));
		System.out.println(getKLargestElements(lists, 3));
	}

	public static ArrayList<Integer> mergeKLists(ArrayList<ArrayList<Integer>> lists) {
		ArrayList<Integer> list = new ArrayList<>();
		GenericHeap<Pair> heap = new GenericHeap<>(Pair.Comparator);

		// fill
		for (int i = 0; i < lists.size(); i++) {
			Pair p = new Pair();
			p.itemNo = 0;
			p.listNo = i;
			p.data = lists.get(i).get(0);
			heap.add(p);
		}

		// while the heap is not empty
		while (heap.size() != 0) {
			Pair top = heap.removeHP();
			list.add(top.data);

			top.itemNo++;
			if (top.itemNo < lists.get(top.listNo).size()) {
				top.data = lists.get(top.listNo).get(top.itemNo);
				heap.add(top);
			}
		}

		return list;
	}

	private static class Pair {
		int data;
		int listNo;
		int itemNo;
		public static final PairComparator Comparator = new PairComparator();

		private static class PairComparator implements Comparator<Pair> {

			@Override
			public int compare(Pair o1, Pair o2) {
				return o2.data - o1.data;
			}
		}
	}

	public static ArrayList<Integer> getKLargestElements(ArrayList<Integer> lists, int k) {
		ArrayList<Integer> rv = new ArrayList<>();
		GenericHeap<Pair> heap = new GenericHeap<>(Pair.Comparator);

		for (int i = 0; i < k; i++) {
			Pair p = new Pair();
			p.data = lists.get(i);
			heap.add(p);
		}

		for (int i = k; i < lists.size(); i++) {
			if (lists.get(i) > heap.getHP().data) {
				heap.removeHP();
				Pair np = new Pair();
				np.data = lists.get(i);
				heap.add(np);
			}
		}

		while (heap.size() != 0) {
			Pair top = heap.removeHP();
			rv.add(top.data);
		}

		return rv;
	}

}
