package July29;

import java.util.ArrayList;

public class Heap {
	private ArrayList<Integer> data = new ArrayList<>();
	private boolean isMin;

	public Heap(boolean isMin) {
		this.isMin = isMin;
	}

	public Heap(boolean isMin, int[] arr) {
		this.isMin = isMin;

		for (int value : arr)
			data.add(value);

		for (int i = arr.length - 1; i >= 0; i--)
			downHeapify(i);
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return data.isEmpty();
	}

	public void display() {
		System.out.println(this.data);
	}

	public void add(int value) {
		data.add(value);
		upHeapify(data.size() - 1);
	}

	private void upHeapify(int ci) {
		if (ci == 0)
			return;

		int pi = (ci - 1) / 2;

		if (isLarger(ci, pi)) {
			swap(ci, pi);
			upHeapify(pi);
		}
	}

	public int removeHP() {
		int rv = data.get(0);
		swap(0, size() - 1);
		data.remove(data.size() - 1);
		downHeapify(0);
		return rv;

	}

	private void downHeapify(int pi) {
		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int max = pi;

		if (lci < data.size() && isLarger(lci, max))
			max = lci;

		if (rci < data.size() && isLarger(rci, max))
			max = rci;

		if (max != pi) {
			swap(max, pi);
			downHeapify(max);
		}
	}

	private boolean isLarger(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		if (isMin == true) {
			if (ith < jth)
				return true;
			else
				return false;

		} else {
			if (ith > jth)
				return true;
			else
				return false;
		}
	}

	private void swap(int i, int j) {
		int ith = data.get(i);
		int jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public int getHP() {
		return data.get(0);
	}

}
