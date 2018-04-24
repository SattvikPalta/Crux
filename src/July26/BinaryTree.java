package July26;

import java.util.LinkedList;
import java.util.Scanner;

public class BinaryTree {
	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BinaryTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, false, scn);
	}

	private Node takeInput(Node parent, boolean ilc, Scanner scn) {
		// prompt
		if (parent == null)
			System.out.println("Enter data for root");
		else {
			if (ilc == true)
				System.out.println("Enter data for " + parent.data);
			else
				System.out.println("Enter data for " + parent.data);
		}

		// collect data
		int data = scn.nextInt();

		// create node, set data and maintain size
		Node child = new Node();
		child.data = data;
		this.size++;

		// Handle left child
		System.out.println("Does " + child.data + " have a left child ?");
		boolean hlc = scn.nextBoolean();

		if (hlc == true)
			child.left = takeInput(child, true, scn);

		// Handle right child
		System.out.println("Does " + child.data + " have a right child ?");
		boolean hrc = scn.nextBoolean();

		if (hrc == true)
			child.right = takeInput(child, false, scn);

		return child;
	}

	public BinaryTree(int[] post, int[] in) {
		root = construct(post, in, 0, post.length - 1, 0, in.length - 1);
	}

	private Node construct(int[] post, int[] in, int psi, int pei, int isi, int iei) {
		if (psi > pei || isi > iei)
			return null;

		Node node = new Node();
		node.data = post[pei];
		this.size++;

		int idx = -1;
		for (int i = isi; i <= iei; i++) {
			if (in[i] == node.data) {
				idx = i;
				break;
			}
		}

		int clse = idx - isi;

		node.left = construct(post, in, psi, psi + clse - 1, isi, idx - 1);
		node.right = construct(post, in, psi + clse, pei - 1, idx + 1, iei);
		return node;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		this.display(root);
	}

	private void display(Node node) {
		if (node == null)
			return;

		String str = "";

		if (node.left != null)
			str += node.left.data;
		else
			str += " . ";

		str += " => " + node.data + " <= ";

		if (node.right != null)
			str += node.right.data;
		else
			str += " . ";

		System.out.println(str);
		display(node.left);
		display(node.right);
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		if (node == null)
			return 0;

		int ls = size2(node.left);
		int rs = size2(node.right);
		return ls + rs + 1;
	}

	public int max() {
		return max(root);
	}

	private int max(Node node) {
		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int max = node.data;

		int left = max(node.left);
		int right = max(node.right);

		if (left > max)
			max = left;

		if (right > max)
			max = right;

		return max;

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null)
			return -1;

		int left = height(node.left);
		int right = height(node.right);

		if (left > right)
			return left + 1;
		else
			return right + 1;
	}

	public boolean find(int data) {
		return find(root, data);
	}

	private boolean find(Node node, int data) {
		if (node == null)
			return false;

		if (node.data == data)
			return true;

		boolean left = find(node.left, data);
		if (left == true)
			return true;

		boolean right = find(node.right, data);
		if (right == true)
			return true;

		return false;
	}

	public int diameter() {
		return diameter(root);
	}

	private int diameter(Node node) {
		if (node == null)
			return 0;

		int leftHeight = height(node.left);
		int rightHeight = height(node.right);
		int leftDia = diameter(node.left);
		int rightDia = diameter(node.right);

		int f1 = leftHeight + rightHeight + 2;
		int f2 = leftDia;
		int f3 = rightDia;

		return Math.max(f1, Math.max(f2, f3));
	}

	private class DiaPair {
		int height;
		int diameter;
	}

	public int diameter2() {
		DiaPair dp = diameter2(root);
		return dp.diameter;
	}

	private DiaPair diameter2(Node node) {
		if (node == null) {
			DiaPair bp = new DiaPair();
			bp.height = -1;
			bp.diameter = 0;
			return bp;
		}

		DiaPair lp = diameter2(node.left);
		DiaPair rp = diameter2(node.right);

		DiaPair mp = new DiaPair();
		mp.height = Math.max(lp.height, rp.height) + 1;
		mp.diameter = Math.max(lp.height + rp.height + 2, Math.max(lp.diameter, rp.diameter));

		return mp;
	}

	private class BalancedPair {
		int height;
		boolean isBal;
	}

	public boolean isBalanced() {
		return isBalanced(root).isBal;
	}

	private BalancedPair isBalanced(Node node) {
		if (node == null) {
			BalancedPair bp = new BalancedPair();
			bp.height = -1;
			bp.isBal = true;
			return bp;
		}

		BalancedPair lp = isBalanced(node.left);
		BalancedPair rp = isBalanced(node.right);

		BalancedPair mp = new BalancedPair();
		mp.height = Math.max(lp.height, rp.height) + 1;

		if (lp.isBal == false)
			return mp;

		else if (rp.isBal == false)
			return mp;

		else {
			int gap = Math.abs(lp.height - rp.height);
			if (gap > 1)
				mp.isBal = false;
			else
				mp.isBal = true;
		}

		return mp;
	}

	private class BSTpair {
		int min;
		int max;
		boolean isBST;
		Node largestBSTroot;
		int LargestBSTsize = 0;
	}

	public void isBST() {
		BSTpair mp = isBST(root);
		System.out.println(mp.isBST);
		System.out.println("Largest BST size is " + mp.LargestBSTsize);
		System.out.println("Largest BST root is " + mp.largestBSTroot.data);
	}

	private BSTpair isBST(Node node) {
		if (node == null) {
			BSTpair bp = new BSTpair();
			bp.min = Integer.MAX_VALUE;
			bp.max = Integer.MIN_VALUE;
			bp.isBST = true;
			return bp;
		}

		BSTpair lp = isBST(node.left);
		BSTpair rp = isBST(node.right);

		BSTpair mp = new BSTpair();
		mp.max = Math.max(lp.max, Math.max(rp.max, node.data));
		mp.min = Math.min(lp.min, Math.min(rp.min, node.data));

		if (lp.isBST && rp.isBST) {
			if (node.data > lp.max && node.data < rp.min)
				mp.isBST = true;
			else
				mp.isBST = false;
		} else {
			mp.isBST = false;
		}

		if (mp.isBST) {
			mp.largestBSTroot = node;
			mp.LargestBSTsize = lp.LargestBSTsize + rp.LargestBSTsize + 1;
		} else {
			if (lp.LargestBSTsize > rp.LargestBSTsize) {
				mp.LargestBSTsize = lp.LargestBSTsize;
				mp.largestBSTroot = lp.largestBSTroot;
			} else {
				mp.LargestBSTsize = rp.LargestBSTsize;
				mp.largestBSTroot = rp.largestBSTroot;
			}
		}

		return mp;
	}

	public void preOrder() {
		preOrder(root);
	}

	private void preOrder(Node node) {
		if (node == null)
			return;

		System.out.print(node.data + ", ");
		preOrder(node.left);
		preOrder(node.right);
	}

	public void postOrder() {
		postOrder(root);
	}

	private void postOrder(Node node) {
		if (node == null)
			return;

		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data + ", ");
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node node) {
		if (node == null)
			return;

		inOrder(node.left);
		System.out.print(node.data + ", ");
		inOrder(node.right);
	}

	private class traversalPair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	public void preOrderIterative() {
		LinkedList<traversalPair> stack = new LinkedList<>();

		traversalPair rp = new traversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();
			if (rp.selfDone == false) {
				System.out.print(rp.node.data + ", ");
				rp.selfDone = true;
			}

			else if (rp.leftDone == false) {
				if (rp.node.left != null) {
					traversalPair rp1 = new traversalPair();
					rp1.node = rp.node.left;
					stack.addFirst(rp1);
				}

				rp.leftDone = true;
			}

			else if (rp.rightDone == false) {
				if (rp.node.right != null) {
					traversalPair rp2 = new traversalPair();
					rp2.node = rp.node.right;
					stack.addFirst(rp2);
				}

				rp.rightDone = true;
			}

			else {
				stack.removeFirst();
			}
		}
	}

	public void postOrderIterative() {
		LinkedList<traversalPair> stack = new LinkedList<>();

		traversalPair rp = new traversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();
			if (rp.leftDone == false) {
				if (rp.node.left != null) {
					traversalPair rp1 = new traversalPair();
					rp1.node = rp.node.left;
					stack.addFirst(rp1);
				}

				rp.leftDone = true;
			}

			else if (rp.rightDone == false) {
				if (rp.node.right != null) {
					traversalPair rp2 = new traversalPair();
					rp2.node = rp.node.right;
					stack.addFirst(rp2);
				}

				rp.rightDone = true;
			}

			else if (rp.selfDone == false) {
				System.out.print(rp.node.data + ", ");
				rp.selfDone = true;
			}

			else {
				stack.removeFirst();
			}
		}
	}

	public void inOrderIterative() {
		LinkedList<traversalPair> stack = new LinkedList<>();

		traversalPair rp = new traversalPair();
		rp.node = root;

		stack.addFirst(rp);
		while (stack.size() != 0) {
			rp = stack.getFirst();
			if (rp.leftDone == false) {
				if (rp.node.left != null) {
					traversalPair rp1 = new traversalPair();
					rp1.node = rp.node.left;
					stack.addFirst(rp1);
				}

				rp.leftDone = true;
			}

			else if (rp.selfDone == false) {
				System.out.print(rp.node.data + ", ");
				rp.selfDone = true;
			}

			else if (rp.rightDone == false) {
				if (rp.node.right != null) {
					traversalPair rp2 = new traversalPair();
					rp2.node = rp.node.right;
					stack.addFirst(rp2);
				}

				rp.rightDone = true;
			}

			else {
				stack.removeFirst();
			}
		}
	}

	public void levelOrderIterative() {
		LinkedList<Node> queue = new LinkedList<>();

		queue.addLast(root);
		while (queue.isEmpty() != true) {
			Node value = queue.removeLast();
			System.out.print(value.data + ", ");

			if (value.left != null)
				queue.addFirst(value.left);

			if (value.right != null)
				queue.addFirst(value.right);
		}
	}

	public void printWithoutSibling() {
		System.out.println(root.data + ", ");
		printWithoutSibling(root);
	}

	private void printWithoutSibling(Node node) {
		if (node == null)
			return;

		if (node.left != null && node.right != null) {
			printWithoutSibling(node.left);
			printWithoutSibling(node.right);
		} else if (node.left != null && node.right == null) {
			System.out.print(node.data + ", ");
			printWithoutSibling(node.left);
		} else if (node.left == null && node.right != null) {
			System.out.println(node.data + ", ");
			printWithoutSibling(node.right);
		} else {
			return;
		}
	}

	public void removeLeaves() {
		removeLeaves(root, null, false);
	}

	private void removeLeaves(Node node, Node parent, boolean ilc) {
		if (node.left == null && node.right == null) {
			if (ilc == true)
				parent.left = null;
			else
				parent.right = null;
		} else {
			if (node.left != null)
				removeLeaves(node.left, node, true);
			if (node.right != null)
				removeLeaves(node.right, node, false);
		}
	}

	public void kAway(int k, int data) {
		kAway(root, k, data);
	}

	private void kAway(Node node, int k, int data) {
		findNprintKAway(root, k, data);
	}

	private int findNprintKAway(Node node, int k, int data) {
		if (node == null)
			return -1;

		if (node.data == data) {
			printKDown(node, k);
			return 0;
		}

		int disFromLeft = findNprintKAway(node.left, k, data);
		if (disFromLeft != -1) {
			if (disFromLeft == k)
				System.out.println(node.data);
			else
				printKDown(node.right, k - (disFromLeft + 2));

			return disFromLeft + 1;
		}

		int disFromRight = findNprintKAway(node.right, k, data);
		if (disFromRight != -1) {
			if (disFromRight == k)
				System.out.println(node.data);
			else
				printKDown(node.left, k - (disFromRight + 2));

			return disFromRight + 1;
		}

		return -1;
	}

	private void printKDown(Node node, int k) {
		if (node == null || k < 0)
			return;

		if (k == 0) {
			System.out.println(node.data);
			return;
		}

		printKDown(node.left, k - 1);
		printKDown(node.right, k - 1);
	}
}
