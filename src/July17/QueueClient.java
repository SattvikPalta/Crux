package July17;

public class QueueClient {

	public static void main(String[] args) throws Exception {
		Queue q = new DynamicQueue();

		q.enqueue(10);
		q.display();

		q.enqueue(20);
		q.display();

		q.enqueue(30);
		q.display();

		q.enqueue(40);
		q.display();

		q.dequeue();
		q.display();

		q.dequeue();
		q.display();

		q.enqueue(50);
		q.display();

		q.enqueue(60);
		q.display();

		q.enqueue(70);
		q.display();

		q.enqueue(80);
		q.display();

		q.dequeue();
		q.display();

		q.dequeue();
		q.display();

		q.dequeue();
		q.display();

		q = displayReverse(q, new Queue());
		q.display();

		reverse(q);
		q.display();
	}

	public static Queue displayReverse(Queue q, Queue q1) throws Exception {
		if (q.size() == 0)
			return q1;

		int value = q.dequeue();
		q1 = displayReverse(q, q1);
		q1.enqueue(value);
		return q1;
	}

	public static void reverse(Queue q) throws Exception {
		if (q.size() == 0)
			return;

		int value = q.dequeue();
		reverse(q);
		q.enqueue(value);
	}

}
