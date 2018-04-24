package July27;

import java.util.LinkedList;

public class BST {

	private class Node {
		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] post, int[] in) {
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

	public BST(int[] sa) {
		root = construct(sa, 0, sa.length - 1);
	}

	private Node construct(int[] sa, int low, int high) {
		if (low > high)
			return null;

		int mid = (low + high) / 2;
		Node node = new Node();
		node.data = sa[mid];
		size++;

		node.left = construct(sa, low, mid - 1);
		node.right = construct(sa, mid + 1, high);

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
		if (node.right == null)
			return node.data;
		else
			return max(node.right);
	}

	public int min() {
		return min(root);
	}

	private int min(Node node) {
		if (node.left == null)
			return node.data;
		else
			return min(node.left);
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

		if (node.data > data)
			return find(node.right, data);
		else if (node.data < data)
			return find(node.left, data);
		else
			return true;
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

	public void add(int data) {
		add(root, data);
	}

	private void add(Node node, int data) {
		if (data > node.data) {
			if (node.right == null) {
				Node temp = new Node();
				temp.data = data;
				node.right = temp;
				size++;
			} else {
				add(node.right, data);
			}
		} else if (data < node.data) {
			if (node.left == null) {
				Node temp = new Node();
				temp.data = data;
				node.left = temp;
				size++;
			} else {
				add(node.left, data);
			}
		} else {
			return;
		}
	}

	public void remove(int data) {
		remove(root, data, null, false);
	}

	private void remove(Node node, int data, Node parent, boolean ilc) {
		if (data == node.data) {
			if (node.left == null && node.right == null) {
				size--;
				if (ilc == false) {
					parent.right = null;
				} else {
					parent.left = null;
				}
			} else if (node.left != null && node.right == null) {
				size--;
				if (ilc == false) {
					parent.right = node.left;
				} else {
					parent.left = node.left;
				}
			} else if (node.left == null && node.right != null) {
				size--;
				if (ilc == false) {
					parent.right = node.right;
				} else {
					parent.left = node.right;
				}
			} else {
				int lmax = max(node.left);
				node.data = lmax;
				remove(node.left, lmax, node, true);
			}
		} else if (data < node.data) {
			remove(node.left, data, node, true);
		} else if (data > node.data) {
			remove(node.right, data, node, false);
		} else {
			return;
		}
	}

	private class HeapMover {
		int sum = 0;
	}

	public void replaceWithSumOfLarger() {
		HeapMover mover = new HeapMover();
		mover.sum = 0;
		replaceWithSumOfLarger(root, mover);
	}

	private void replaceWithSumOfLarger(Node node, HeapMover mover) {
		if (node == null)
			return;

		replaceWithSumOfLarger(node.right, mover);

		int temp = node.data;
		node.data = mover.sum;
		mover.sum += temp;

		replaceWithSumOfLarger(node.right, mover);
	}

	public void printInRange(int low, int high) {
		printInRange(root, low, high);
	}

	private void printInRange(Node node, int low, int high) {
		if (node == null)
			return;

		if (node.data > high) {
			printInRange(node.left, low, high);
		} else if (node.data < low) {
			printInRange(node.right, low, high);
		} else {
			System.out.print(node.data + ", ");
			printInRange(node.left, low, high);
			printInRange(node.right, low, high);
		}
	}

	public void rootToLeafPath(int target) {
		rootToLeafPath(root, target, "");
	}

	private void rootToLeafPath(Node node, int target, String psf) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null && target == node.data){
			System.out.println(psf + node.data);
			return;
		}

		rootToLeafPath(node.left, target - node.data, psf + node.data + " => ");
		rootToLeafPath(node.right, target - node.data, psf + node.data + " => ");
	}
}
