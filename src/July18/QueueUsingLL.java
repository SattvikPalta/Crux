package July18;

public class QueueUsingLL {

	private LinkedList ll;

	public QueueUsingLL() {
		this.ll = new LinkedList();
	}

	public void enqueue(int value) {
		ll.addLast(value);
	}

	public int dequeue() throws Exception {
		return ll.removeFirst();
	}

	public int size() {
		return ll.size();
	}

	public boolean isEmpty() {
		return ll.isEmpty();
	}

	public void display() {
		ll.display();
	}

}
