package July17;

public class Queue {
	protected int[] data;
	protected int front;
	protected int size;
	protected int tail;

	public Queue() {
		this(5);
	}

	Queue(int capacity) {
		this.data = new int[capacity];
	}

	public void enqueue(int value) throws Exception {
		if (this.size == data.length)
			throw new Exception("Queue is full");

		this.tail = (this.front + this.size) % data.length;
		this.data[tail] = value;
		this.size++;
	}

	public int dequeue() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is empty");

		int rv = this.data[this.front];
		this.front = (this.front + 1) % data.length;
		this.size--;
		return rv;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() throws Exception {
		if (this.size == 0)
			throw new Exception("Queue is empty");

		for (int i = 0; i < this.size; i++)
			System.out.print(this.data[(front + i) % data.length] + "\t");

		System.out.println();
		System.out.println("-------------------------------------------");
	}

}