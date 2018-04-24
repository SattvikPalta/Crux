package July17;

public class StackUsing2Queue {

	private Queue q1;
	private Queue q2;

	public StackUsing2Queue() {
		this.q1 = new Queue();
		this.q2 = new Queue();
	}

	public void push(int value) throws Exception {
		q1.enqueue(value);
	}

	public int top() throws Exception {
		while (q1.size != 1) {
			int value = q1.dequeue();
			q2.enqueue(value);
		}

		int rv = q1.dequeue();
		q1.enqueue(rv);
		
		while (q2.size != 0) {
			int value = q2.dequeue();
			q1.enqueue(value);
		}
		
		return rv;
	}

	public int pop() throws Exception {
		while (q1.size != 1) {
			int value = q1.dequeue();
			q2.enqueue(value);
		}

		int rv = q1.dequeue();

		while (q2.size != 0) {
			int value = q2.dequeue();
			q1.enqueue(value);
		}
		
		return rv;
	}

	public int size() {
		return q1.size;
	}

	public boolean isEmpty() {
		return q1.isEmpty();
	}

	public void display() throws Exception {
		q1.display();
	}

}
