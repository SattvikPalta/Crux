package July12;

public class Stack {
	protected int[] data;
	protected int tos = -1;

	public Stack() {
		this(5);
	}

	Stack(int capacity) {
		this.data = new int[capacity];
	}

	public void push(int value) throws Exception {
		if (this.tos == data.length - 1)
			throw new Exception("Stack is full");

		this.tos++;
		this.data[this.tos] = value;
	}

	public int top() throws Exception {
		if (this.tos == -1)
			throw new Exception("Stack is empty");

		return this.data[this.tos];
	}

	public int pop() throws Exception {
		if (this.tos == -1)
			throw new Exception("Stack is empty");

		int value = this.data[this.tos];
		this.tos--;
		return value;
	}

	public int size() {
		return this.tos + 1;
	}

	public boolean isEmpty() {
		return this.tos == -1;
	}

	public void display() {
		for (int i = tos; i >= 0; i--)
			System.out.print(this.data[i] + "\t");

		System.out.println();
		System.out.println("----------------------------------------------");
	}

}