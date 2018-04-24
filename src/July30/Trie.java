package July30;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {
	private class Node {
		Character data;
		boolean eow;
		HashMap<Character, Node> children = new HashMap<>();
	}

	private Node root = new Node();
	private int numWords = 0;
	private int numNodes = 1;

	public void addWord(String word) {
		addWord(root, word);
	}

	private void addWord(Node node, String word) {
		if (word.length() == 0) {
			this.numWords++;
			node.eow = true;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = node.children.get(ch);

		if (child != null) {
			addWord(child, row);
		} else {
			this.numNodes++;
			child = new Node();
			child.data = ch;
			node.children.put(ch, child);
			addWord(child, row);
		}
	}

	public void removeWord(String word) {
		removeWord(root, word);
	}

	private void removeWord(Node node, String word) {
		if (word.length() == 0) {
			this.numWords--;
			node.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = node.children.get(ch);

		if (child != null) {
			removeWord(child, row);
			if (child.children.size() == 0 && child.eow == false) {
				node.children.remove(child);
				numNodes--;
			}
		} else {
			return;
		}
	}

	public boolean searchWord(String word) {
		return searchWord(root, word);
	}

	private boolean searchWord(Node node, String word) {
		if (word.length() == 0)
			return node.eow;

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = node.children.get(ch);

		if (child != null)
			return searchWord(child, row);
		else
			return false;
	}

	public void display() {
		display(root, "");
	}

	private void display(Node node, String osf) {
		if (node.eow)
			System.out.println(osf);

		ArrayList<Character> keys = new ArrayList<>(node.children.keySet());
		for (Character key : keys) {
			Node child = node.children.get(key);
			display(child, osf + key);
		}
	}

}
