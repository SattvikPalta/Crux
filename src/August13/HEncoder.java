package August13;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

import July31.GenericHeap;

public class HEncoder {
	private HashMap<Character, String> encoder = new HashMap<>();
	private HashMap<String, Character> decoder = new HashMap<>();

	private static class Node {
		Character data;
		int freq;
		Node left;
		Node right;

		private static final NodeComparator ctor = new NodeComparator();

		private static class NodeComparator implements Comparator<Node> {

			@Override
			public int compare(Node o1, Node o2) {
				// TODO Auto-generated method stub
				return o2.freq - o1.freq;
			}
		}
	}

	public HEncoder(String Feeder) {
		// 1. freq map
		HashMap<Character, Integer> freqMap = new HashMap<>();
		for (int i = 0; i < Feeder.length(); i++) {
			char ch = Feeder.charAt(i);

			if (freqMap.containsKey(ch))
				freqMap.put(ch, freqMap.get(ch) + 1);
			else
				freqMap.put(ch, 1);
		}

		// 2. create nodes for all keys and fill the heap
		GenericHeap<Node> heap = new GenericHeap<>(Node.ctor);
		ArrayList<Character> keys = new ArrayList<>(freqMap.keySet());
		for (Character key : keys) {
			Node node = new Node();
			node.data = key;
			node.freq = freqMap.get(key);
			heap.add(node);
		}

		// 3. till heap size is 1 -> remove two, merge and put it back
		while (heap.size() != 1) {
			Node one = heap.removeHP();
			Node two = heap.removeHP();

			Node merged = new Node();
			merged.freq = one.freq + two.freq;
			merged.left = one;
			merged.right = two;

			heap.add(merged);
		}

		// 4. get the final node out
		Node finalNode = heap.removeHP();
		fillEncoderDecoder(finalNode, "");
	}

	private void fillEncoderDecoder(Node node, String osf) {
		if (node == null)
			return;

		if (node.left == null && node.right == null) {
			encoder.put(node.data, osf);
			decoder.put(osf, node.data);
		}

		fillEncoderDecoder(node.left, osf + "0");
		fillEncoderDecoder(node.right, osf + "1");
	}

	public String compress(String str) {
		String rv = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			rv += encoder.get(ch);
		}

		return rv;
	}

	public String decompress(String str) {
		String rv = "";
		String key = "";

		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			key += ch;

			if (decoder.containsKey(key)) {
				rv += decoder.get(key);
				key = "";
			}
		}

		return rv;
	}
}
