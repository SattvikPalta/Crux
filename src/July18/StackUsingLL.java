package July18;

public class StackUsingLL {

	private LinkedList ll;

	public StackUsingLL() {
		this.ll = new LinkedList();
	}

	public void push(int value) throws Exception {
		ll.addFirst(value);
	}

	public int top() throws Exception {
		return ll.getFirst();
	}

	public int pop() throws Exception {
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
