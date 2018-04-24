package July12;

public class StackClient {

	public static void main(String[] args) throws Exception {
		Stack st = new DynamicStack();

		st.push(10);
		st.display();

		st.push(20);
		st.display();

		st.push(30);
		st.display();

		st.push(40);
		st.display();

		st.push(50);
		st.display();

		st.push(60);
		st.display();

//		System.out.println(st.top());
//
//		System.out.println(st.pop());
//
//		System.out.println(st.size());
//
//		System.out.println(st.isEmpty());
//
//		displayReverse(st);
//		st.display();
//
//		st = reverse(st, new Stack());
//		st.display();
	}

	public static void displayReverse(Stack st) throws Exception {
		if (st.isEmpty())
			return;

		int value = st.pop();
		displayReverse(st);
		System.out.print(value + "\t");
	}

	public static Stack reverse(Stack st, Stack st1) throws Exception {
		if (st.size() == 0)
			return st1;

		int value = st.pop();
		st1.push(value);
		st1 = reverse(st, st1);
		return st1;
	}

}
