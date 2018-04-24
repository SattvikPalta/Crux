package August6;

import java.util.ArrayList;

public class HashMap<K, V> {
	private class Node {
		K key;
		V value;
	}

	private GenericLinkedList<Node>[] buckets; // N
	private int size = 0; // n

	public HashMap() {
		buckets = new GenericLinkedList[4];
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new GenericLinkedList<>();

		size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			Node node = new Node();
			node.key = key;
			node.value = value;
			buckets[bi].addLast(node);
			this.size++;
		} else {
			Node node = buckets[bi].getAt(foundAt);
			node.value = value;
		}

		double lambda = (size * 1.0) / buckets.length;
		if (lambda > 2.0)
			reHash();
	}

	public V get(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			return null;
		} else {
			Node node = buckets[bi].getAt(foundAt);
			return node.value;
		}
	}

	public V remove(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1) {
			return null;
		} else {
			Node node = buckets[bi].removeAt(foundAt);
			this.size--;
			return node.value;
		}
	}

	public boolean containsKey(K key) throws Exception {
		int bi = hashFunction(key);
		int foundAt = findInBucket(buckets[bi], key);

		if (foundAt == -1)
			return false;
		else
			return true;
	}

	public ArrayList<K> keySet() throws Exception {
		ArrayList<K> rv = new ArrayList<>();
		for (int i = 0; i < buckets.length; i++) {
			for (int j = 0; j < buckets[i].size(); j++) {
				Node node = buckets[i].getAt(j);
				rv.add(node.key);
			}
		}
		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {
		System.out.println("------------------------------------");
		for (int i = 0; i < buckets.length; i++) {
			String str = "BUCKET " + i + " => ";
			for (int j = 0; j < buckets[i].size(); j++) {
				Node node = buckets[i].getAt(j);
				str += "[" + node.key + "@" + node.value + "]";
			}
			System.out.println(str + ".");
		}
	}

	private int hashFunction(K key) {
		int hc = key.hashCode();
		hc = Math.abs(hc);

		int bi = hc % buckets.length;
		return bi;
	}

	private int findInBucket(GenericLinkedList<Node> list, K key) throws Exception {
		for (int i = 0; i < list.size(); i++) {
			Node node = list.getAt(i);
			if (node.key.equals(key))
				return i;
		}
		return -1;
	}

	private void reHash() throws Exception {
		GenericLinkedList<Node>[] oba = buckets;
		buckets = new GenericLinkedList[2 * oba.length];
		
		for (int i = 0; i < buckets.length; i++)
			buckets[i] = new GenericLinkedList<>();

		size = 0;

		for (int i = 0; i < oba.length; i++) {
			for (int j = 0; j < oba[i].size(); j++) {
				Node node = oba[i].getAt(j);
				this.put(node.key, node.value);
			}
		}

	}

}
