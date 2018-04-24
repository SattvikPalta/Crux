package August6;

public class GenericLinkedList<T> {

	private class Node {
		T data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// complexity - o(1)
	public void addFirst(T data) {
		Node node = new Node();
		node.data = data;
		node.next = this.head;
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.head = node;
		}
		this.size++;
	}

	// complexity - o(1)
	public void addLast(T data) {
		Node node = new Node();
		node.data = data;
		node.next = null;
		if (this.size == 0) {
			this.head = node;
			this.tail = node;
		} else {
			this.tail.next = node;
			this.tail = node;
		}
		this.size++;
	}

	// complexity - o(n)
	public void addAt(T data, int idx) throws Exception {
		if (idx < 0 || idx > this.size)
			throw new Exception("Index out of bounds");
		else if (idx == 0)
			addFirst(data);
		else if (idx == this.size)
			addLast(data);
		else {
			Node natidxm1 = getNodeAt(idx - 1);
			Node natidxp1 = natidxm1.next;
			Node node = new Node();
			node.data = data;
			node.next = natidxp1;
			natidxm1.next = node;
			this.size++;
		}
	}

	// complexity - o(1)
	public T getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		return this.head.data;
	}

	// complexity - o(1)
	public T getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		return this.tail.data;
	}

	// complexity - o(n)
	public T getAt(int idx) throws Exception {
		Node natidx = getNodeAt(idx);
		return natidx.data;
	}

	// complexity - o(n)
	private Node getNodeAt(int idx) throws Exception {
		if (this.size == 0)
			throw new Exception("Linked list is empty");

		if (idx < 0 || idx >= this.size)
			throw new Exception("Index out of bounds");

		Node node = this.head;
		for (int i = 0; i < idx; i++)
			node = node.next;

		return node;
	}

	// complexity - o(1)
	public T removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		T rv = this.head.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			this.head = this.head.next;
		}

		this.size--;
		return rv;
	}

	// complexity - o(n)
	public T removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		T rv = this.tail.data;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
		} else {
			Node sm2 = this.getNodeAt(size - 2);
			this.tail = sm2;
			this.tail.next = null;
		}

		this.size--;
		return rv;
	}

	// complexity - o(n)
	public T removeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bounds");
		} else if (idx == 0) {
			T rv = removeFirst();
			return rv;
		} else if (idx == this.size - 1) {
			T rv = removeLast();
			return rv;
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node node = nm1.next;
			Node np1 = node.next;
			nm1.next = np1;
			this.size--;
			return node.data;
		}
	}

	public int size() {
		return this.size;
	}

	// complexity - o(1)
	public boolean isEmpty() {
		return this.size == 0;
	}

	// complexity - o(n)
	public void display() {
		for (Node temp = this.head; temp != null; temp = temp.next)
			System.out.print(temp.data + "\t");

		System.out.println();
		System.out.println("-------------------------------------------------------------------");
	}
}
