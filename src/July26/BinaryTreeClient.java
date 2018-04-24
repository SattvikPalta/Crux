package July26;

public class BinaryTreeClient {
	public static void main(String[] args) {
		// 50 true 25 true 12 false false true 37 true 30 false false true 51 false false true 75 true 62 false false true 87 false false

		int[] post = { 12, 30, 40, 37, 25, 62, 87, 75, 50 };
		int[] in = { 12, 25, 30, 37, 40, 50, 62, 75, 87 };
		BinaryTree bt = new BinaryTree(post, in);
		bt.display();

//		BinaryTree bt = new BinaryTree();
//		bt.display();
//
//		System.out.println(bt.size2());
//
//		System.out.println(bt.max());
//
//		System.out.println(bt.height());
//
//		System.out.println(bt.find(62));
//
//		System.out.println(bt.diameter());
//
//		System.out.println(bt.diameter2());
//
//		System.out.println(bt.isBalanced());
//
//		bt.preOrder();
//		System.out.println();
//
//		bt.postOrder();
//		System.out.println();
//
//		bt.inOrder();
//		System.out.println();
//
//		bt.preOrderIterative();
//		System.out.println();
//
//		bt.postOrderIterative();
//		System.out.println();
//
//		bt.inOrderIterative();
//		System.out.println();
//
//		bt.levelOrderIterative();
//
//		bt.printWithoutSibling();
//
//		System.out.println();
//		bt.removeLeaves();
//		bt.display();
//		
//		bt.isBST();
		
		bt.kAway(4, 37);
	}

}
