package Assignment_10;

import July17.StackUsing2Queue;

public class A10Q2 {

	public static void main(String[] args) throws Exception {
		StackUsing2Queue st = new StackUsing2Queue();
		
		st.push(10);
		
		st.push(20);
		
		st.push(30);
		
		st.push(40);

		st.push(50);
		
		st.display();

		st.pop();
		
		st.pop();
		
		st.display();
		
		System.out.println(st.top());
		
		System.out.println(st.size());
		
		System.out.println(st.isEmpty());
	}

}
