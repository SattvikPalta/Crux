package July31;

import java.util.ArrayList;
import java.util.Comparator;

public class GenericHeap<T> {

	private ArrayList<T> data = new ArrayList<>();
	private Comparator<T> ctor;

	public GenericHeap(Comparator<T> ctor) {
		this.ctor = ctor;
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

	public void add(T value) {
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

	public T removeHP() {
		T rv = data.get(0);
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
		T ith = data.get(i);
		T jth = data.get(j);

		if (ctor.compare(ith, jth) > 0)
			return true;
		else
			return false;
	}

	private void swap(int i, int j) {
		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);
	}

	public T getHP() {
		return data.get(0);
	}

	public void updatePriority(T value) {
		int idx = -1;
		for (int i = 0; i < data.size(); i++) {
			if (data.get(i).equals(value)) {
				idx = i;
				break;
			}
		}

		upHeapify(idx);
		downHeapify(idx);
	}

}
