package July18;

public class LinkedList {
	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	// complexity - o(1)
	public void addFirst(int data) {
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
	public void addLast(int data) {
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
	public void addAt(int data, int idx) throws Exception {
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
	public int getFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		return this.head.data;
	}

	// complexity - o(1)
	public int getLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		return this.tail.data;
	}

	// complexity - o(n)
	public int getAt(int idx) throws Exception {
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
	public int removeFirst() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		int rv = this.head.data;

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
	public int removeLast() throws Exception {
		if (this.size == 0)
			throw new Exception("Index out of bounds");

		int rv = this.tail.data;

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
	public int removeAt(int idx) throws Exception {
		if (idx < 0 || idx >= this.size) {
			throw new Exception("Index out of bounds");
		} else if (idx == 0) {
			int rv = removeFirst();
			return rv;
		} else if (idx == this.size - 1) {
			int rv = removeLast();
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

	// complexity - o(1)
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

	// complexity - o(n^2)
	public void reverseDataIterative() throws Exception {
		int left = 0, right = this.size - 1;
		while (left <= right) {
			Node leftNode = getNodeAt(left);
			Node rightNode = getNodeAt(right);

			int temp = leftNode.data;
			leftNode.data = rightNode.data;
			rightNode.data = temp;

			left++;
			right--;
		}
	}

	// complexity - o(n)
	public void reversePointerIterative() {
		Node previous = this.head;
		Node current = previous.next;

		while (current != null) {
			Node next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	// complexity - o(n)
	public void reversePointerRecursive() {
		reversePointerRecursive(this.head, this.head.next);

		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	private void reversePointerRecursive(Node previous, Node current) {
		if (current == null)
			return;

		Node next = current.next;
		current.next = previous;

		reversePointerRecursive(current, next);
	}

	// complexity - o(n)
	public void reverseDataRecursive() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		reverseDataRecursive(left, this.head, 0);
	}

	private void reverseDataRecursive(HeapMover left, Node right, int floor) {
		if (right == null)
			return;

		reverseDataRecursive(left, right.next, floor + 1);

		if (floor >= this.size / 2) {
			int temp = left.node.data;
			left.node.data = right.data;
			right.data = temp;
		}

		left.node = left.node.next;

	}

	private class HeapMover {
		Node node;
	}

	// complexity - o(n)
	public boolean isPalindrome() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		return isPalindrome(left, this.head);
	}

	private boolean isPalindrome(HeapMover left, Node right) {
		if (right == null)
			return true;

		boolean result = isPalindrome(left, right.next);

		if (result == true) {
			if (left.node.data != right.data) {
				return false;
			} else {
				left.node = left.node.next;
				return true;
			}
		} else {
			return false;
		}
	}

	public void fold() {
		HeapMover left = new HeapMover();
		left.node = this.head;
		fold(left, this.head, 0);
	}

	private void fold(HeapMover left, Node right, int floor) {
		if (right == null)
			return;

		fold(left, right.next, floor + 1);

		if (floor > this.size / 2) {
			Node oln = left.node.next;
			left.node.next = right;
			right.next = oln;
			left.node = oln;
		}

		if (floor == this.size / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public int kthFromLast(int k) {
		Node slow = this.head;
		Node fast = this.head;

		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}

		while (fast != null) {
			slow = slow.next;
			fast = fast.next;
		}

		return slow.data;
	}

	public int midElement() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow.data;
	}

	public void removeDuplicates() {
		Node tempNext = new Node();
		tempNext = this.head;

		while (tempNext.next != null) {
			if (tempNext.data == tempNext.next.data)
				tempNext.next = tempNext.next.next;
			else
				tempNext = tempNext.next;
		}
	}

	public LinkedList merge2SortedLL(LinkedList other) {
		Node thisHead = this.head;
		Node otherHead = other.head;

		LinkedList merged = new LinkedList();

		while (thisHead != null && otherHead != null) {
			if (thisHead.data < otherHead.data) {
				merged.addLast(thisHead.data);
				thisHead = thisHead.next;
			} else {
				merged.addLast(otherHead.data);
				otherHead = otherHead.next;
			}
		}

		while (thisHead != null) {
			merged.addLast(thisHead.data);
			thisHead = thisHead.next;
		}

		while (otherHead != null) {
			merged.addLast(otherHead.data);
			otherHead = otherHead.next;
		}

		return merged;
	}

	private Node midNode() {
		Node slow = this.head;
		Node fast = this.head;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public LinkedList mergeSort() {
		if (this.size == 1)
			return this;

		Node mid = midNode();
		Node midNext = mid.next;

		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = midNext;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;

		fh = fh.mergeSort();
		sh = sh.mergeSort();

		return fh.merge2SortedLL(sh);
	}

	public void kReverse(int k) throws Exception {
		LinkedList prev = null;
		LinkedList curr = new LinkedList();

		while (!this.isEmpty()) {
			for (int i = 0; i < k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}

			curr = new LinkedList();
		}

		this.head = prev.head;
		this.tail = prev.tail;
		this.size = prev.size;
	}

}
