package July29;

public class HeapClient {

	public static void main(String[] args) {
//		Heap hp = new Heap(true);
		
		int[] arr = {40, 30, 70, 50, 10, 20, 60};
		Heap hp = new Heap(true, arr);

//		hp.add(40);
//		hp.add(30);
//		hp.add(70);
//		hp.add(50);
//		hp.add(10);
//		hp.add(20);
//		hp.add(60);

		hp.display();
		while (hp.size() != 0)
			System.out.print(hp.removeHP() + " ");

	}

}
