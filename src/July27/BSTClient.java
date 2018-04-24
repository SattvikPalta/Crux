package July27;

public class BSTClient {

	public static void main(String[] args) {
//		 50 true 25 true 12 false false true 37 true 30 false false true 40 false true 75 true 62 false false true 87 false false
		int[] post = { 12, 30, 40, 37, 25, 62, 87, 75, 50 };
		int[] in = { 12, 25, 30, 37, 40, 50, 62, 75, 87 };
		BST bst = new BST(post, in);
//		bst.display();

//		int[] sa = { 10, 20, 30, 40, 50, 60, 70 };
//		BST bst = new BST(sa);
//		bst.display();
//
//		System.out.println(bst.max());
//
//		System.out.println(bst.min());
//
//		System.out.println(bst.find(62));
//
//		bst.add(90);
//		bst.display();
//		
//		bst.remove(40);
//		bst.display();
//		
//		bst.replaceWithSumOfLarger();
//		bst.display();
//		
//		bst.printInRange(0, 40);
//		
//		bst.rootToLeafPath(87);
	}

}
