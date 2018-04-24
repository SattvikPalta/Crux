package July24;

import java.util.ArrayList;
import java.util.Scanner;

import javax.xml.soap.Node;

import java.util.LinkedList;

public class GenericTree {
	private class Node {
		int data;
		ArrayList<Node> children = new ArrayList<>();
	}

	private Node root;
	private int size;

	public GenericTree() {
		Scanner scn = new Scanner(System.in);
		root = takeInput(null, -1, scn);
	}

	private Node takeInput(Node parent, int childIdx, Scanner scn) {
		// prompt
		if (parent == null) {
			System.out.println("Enter data for root");
		} else {
			System.out.println("Enter data for " + childIdx + "th of " + parent.data);
		}

		// collect data
		int data = scn.nextInt();

		// create node, set data and maintain size
		Node child = new Node();
		child.data = data;
		this.size++;

		// create and attach grandchild
		System.out.println("Enter the number of children for " + child.data);
		int nGrandChild = scn.nextInt();

		for (int i = 0; i < nGrandChild; i++) {
			Node GrandChild = takeInput(child, i, scn);
			child.children.add(GrandChild);
		}

		return child;
	}

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {
		String str = node.data + " => ";
		for (Node child : node.children)
			str += child.data + ", ";

		str += ".";
		System.out.println(str);

		for (Node child : node.children)
			display(child);
	}

	public int size2() {
		return size2(root);
	}

	private int size2(Node node) {
		int size = 0;

		for (Node child : node.children) {
			int countSize = size2(child);
			size += countSize;
		}

		size = size + 1; // for the node itself
		return size;
	}

	public int max() {
		return max(this.root);
	}

	private int max(Node node) {
		int max = 0;

		for (Node child : node.children) {
			int m = max(child);
			if (m > max)
				max = m;
		}

		if (node.data > max)
			return node.data;
		else
			return max;
	}

	public int height() {
		return height(this.root) - 1;
	}

	private int height(Node node) {
		int height = 0;

		for (Node child : node.children) {
			int h = height(child);
			if (h > height)
				height = h;
		}

		height = height + 1;
		return height;
	}

	public boolean find(int data) {
		return find(this.root, data);
	}

	private boolean find(Node node, int data) {
		if (node.data == data)
			return true;

		for (Node child : node.children) {
			boolean fc = find(child, data);
			if (fc == true)
				return true;
		}

		return false;
	}

	public void mirror() {
		mirror(this.root);
	}

	private void mirror(Node node) {
		for (Node child : node.children)
			mirror(child);

		int left = 0;
		int right = node.children.size() - 1;
		while (left < right) {
			Node temp = node.children.get(left);
			node.children.set(left, node.children.get(right));
			node.children.set(right, temp);
			left++;
			right--;
		}
	}

	public void printAtDepth(int depth) {
		printAtDepth(this.root, depth - 1);
	}

	private void printAtDepth(Node node, int depth) {
		if (depth == -1)
			System.out.println(node.data);

		if (depth == 0)
			for (Node child : node.children)
				System.out.print(child.data + "\t");

		for (Node child : node.children)
			printAtDepth(child, depth - 1);
	}

	public void preOrder() {
		preOrder(this.root);
	}

	public void preOrder(Node node) {
		System.out.print(node.data + "\t");
		for (Node child : node.children)
			preOrder(child);
	}

	public void postOrder() {
		postOrder(this.root);
	}

	public void postOrder(Node node) {
		for (Node child : node.children)
			postOrder(child);

		System.out.print(node.data + "\t");
	}

	public void levelOrder() throws Exception {
		LinkedList<Node> queue = new LinkedList<>();
		queue.addLast(root);

		while (!queue.isEmpty()) {
			Node temp = queue.removeFirst();
			System.out.print(temp.data + "\t");

			for (Node child : temp.children)
				queue.addLast(child);

		}
	}

	public void levelOrderLW() throws Exception {
		LinkedList<Node> queue1 = new LinkedList<>();
		LinkedList<Node> queue2 = new LinkedList<>();

		queue1.addLast(root);

		while (!queue1.isEmpty()) {
			Node temp = queue1.removeFirst();
			System.out.print(temp.data + "\t");

			for (Node child : temp.children)
				queue2.addLast(child);

			if (queue1.isEmpty()) {
				System.out.println();
				queue1 = queue2;
				queue2 = new LinkedList<>();
			}
		}

		System.out.println();
	}

	private class HeapMover {
		int size;
		int height;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		boolean find;
		int predecessor;
		int successor;
		int justLarger = Integer.MAX_VALUE;

		ArrayList<Node> children = new ArrayList<>();
	}

	public void multiSolver(int data) {
		HeapMover mover = new HeapMover();
		multiSolver(this.root, mover, data, 0);

		System.out.println("Size = " + mover.size);
		System.out.println("Height = " + mover.height);
		System.out.println("Max = " + mover.max);
		System.out.println("Min = " + mover.min);
		System.out.println(mover.find);

		if (mover.predecessor == 0 || mover.find == false)
			System.out.println("Predecessor not found");
		else
			System.out.println("Predecessor = " + mover.predecessor);

		if (mover.successor == 0)
			System.out.println("successor not found");
		else
			System.out.println("successor = " + mover.successor);

		if (mover.justLarger == 0)
			System.out.println("justLarger not found");
		else
			System.out.println("justLarger = " + mover.justLarger);
	}

	private void multiSolver(Node node, HeapMover mover, int data, int depth) {
		mover.size++;
		if (depth > mover.height)
			mover.height = depth;

		if (node.data > mover.max)
			mover.max = node.data;

		if (node.data < mover.min)
			mover.min = node.data;

		if (mover.find == true && mover.successor == 0)
			mover.successor = node.data;

		if (node.data == data)
			mover.find = true;

		if (mover.find == false)
			mover.predecessor = node.data;

		if (node.data > data) {
			int jl = node.data;
			if (jl < mover.justLarger)
				mover.justLarger = jl;
		}

		for (Node child : node.children)
			multiSolver(child, mover, data, depth + 1);
	}

	public int KthSmallest(int k) {
		int data = Integer.MIN_VALUE;

		while (k != 0) {
			HeapMover mover = new HeapMover();
			KthSmallest(root, mover, k, data);
			data = mover.justLarger;
			k--;
		}

		return data;
	}

	private void KthSmallest(Node node, HeapMover mover, int k, int data) {
		if (node.data > data) {
			int jl = node.data;
			if (jl < mover.justLarger)
				mover.justLarger = jl;
		}

		for (Node child : node.children)
			KthSmallest(child, mover, k, data);

	}

	public void removeLeaves() {
		removeLeaves(root);
	}

	private void removeLeaves(Node node) {
		for (int i = node.children.size() - 1; i >= 0; i--) {
			Node child = node.children.get(i);

			if (child.children.size() == 0)
				node.children.remove(child);
		}

		for (Node child : node.children)
			removeLeaves(child);
	}

	public void linearize() {
		linearize(this.root);
	}

	private Node linearize(Node node) {
		if (node.children.size() == 0)
			return node;

		Node tail = null;
		for (Node child : node.children) {
			if (tail != null)
				tail.children.add(child);

			tail = linearize(child);
		}

		while (node.children.size() > 1)
			node.children.remove(node.children.size() - 1);

		return tail;
	}

	public void flatten() {
		HeapMover mover = new HeapMover();
		flatten(this.root, mover);
		root.children = mover.children;
	}

	private void flatten(Node node, HeapMover mover) {
		if (node != root)
			mover.children.add(node);

		for (Node child : node.children)
			flatten(child, mover);

		node.children.clear();
	}

	public boolean isIsomorphic(GenericTree other) {
		return isIsomorphic(this.root, other.root);
	}

	private boolean isIsomorphic(Node thisNode, Node otherNode) {
		if (thisNode.children.size() != otherNode.children.size())
			return false;

		for (int i = 0; i < thisNode.children.size(); i++) {
			Node thisChild = thisNode.children.get(i);
			Node otherChild = otherNode.children.get(i);

			if (this.isIsomorphic(thisChild, otherChild) == false)
				return false;
		}

		return true;
	}

	public boolean isMirrorIso() {
		return isMirrorIso(root, root);
	}

	private boolean isMirrorIso(Node lmNode, Node rmNode) {
		if (lmNode.children.size() != rmNode.children.size())
			return false;

		for (int i = 0; i < lmNode.children.size(); i++) {
			Node lmChild = lmNode.children.get(i);
			Node rmChild = rmNode.children.get(rmNode.children.size() - 1 - i);

			if (isMirrorIso(lmChild, rmChild) == false)
				return false;
		}

		return true;
	}
}