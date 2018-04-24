package July29;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapClient {

	public static void main(String[] args) {
//		HashMap<String, Integer> pplMap = new HashMap<>();
//
//		pplMap.put("India", 200);
//		pplMap.put("Pak", 150);
//		pplMap.put("US", 40);
//		pplMap.put("UK", 30);
//
//		System.out.println(pplMap);
//
//		System.out.println(pplMap.get("India"));
//
//		System.out.println(pplMap.remove("Pak"));
//
//		System.out.println(pplMap);
//
//		System.out.println(pplMap.containsKey("India"));
//
//		ArrayList<String> list = new ArrayList<>(pplMap.keySet());
//		System.out.println(list);
//
//		System.out.println(maxFrequency("aaabbcddee"));
//
//		int[] one = { 1, 1, 2, 2, 2, 3, 5 };
//		int[] two = { 1, 1, 1, 1, 2, 2, 4, 5 };
//
//		System.out.println(GCE1(one, two));
//
//		System.out.println(GCE2(one, two));
//
//		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 6 };
//		longestSequence(arr);
	}

	public static Character maxFrequency(String word) {
		HashMap<Character, Integer> hm = new HashMap<>();

		for (int i = 0; i < word.length(); i++) {
			Character ch = word.charAt(i);

			if (hm.containsKey(ch))
				hm.put(ch, hm.get(ch) + 1);
			else
				hm.put(ch, 1);
		}

		ArrayList<Character> list = new ArrayList<>(hm.keySet());
		int maxf = 0;
		char maxc = ' ';

		for (int i = 0; i < list.size(); i++) {
			int freq = hm.get(list.get(i));

			if (freq > maxf) {
				maxf = freq;
				maxc = list.get(i);
			}
		}

		return maxc;
	}

	public static ArrayList<Integer> GCE1(int[] one, int[] two) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (hm.containsKey(one[i]))
				hm.put(one[i], hm.get(one[i]) + 1);
			else
				hm.put(one[i], 1);
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {
			if (hm.containsKey(two[i])) {
				hm.remove(two[i]);
				list.add(two[i]);
			}
		}

		return list;
	}

	public static ArrayList<Integer> GCE2(int[] one, int[] two) {
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int i = 0; i < one.length; i++) {
			if (hm.containsKey(one[i]))
				hm.put(one[i], hm.get(one[i]) + 1);
			else
				hm.put(one[i], 1);
		}

		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < two.length; i++) {
			if (hm.containsKey(two[i])) {
				if (hm.get(two[i]) > 0) {
					hm.put(two[i], hm.get(two[i]) - 1);
					list.add(two[i]);
				} else {
					hm.remove(two[i]);
				}
			}
		}

		return list;
	}

	public static void longestSequence(int[] arr) {
		HashMap<Integer, Boolean> hm = new HashMap<>();

		for (int val : arr)
			hm.put(val, true);

		for (int val : arr)
			if (hm.containsKey(val - 1))
				hm.put(val, false);

		int maxStart = 0;
		int maxLen = 0;

		for (int val : arr) {
			if (hm.get(val) == true) {
				int seqLen = 0;
				while (hm.containsKey(val + seqLen))
					seqLen++;

				if (seqLen > maxLen) {
					maxLen = seqLen;
					maxStart = val;
				}
			}
		}

		for (int i = 0; i < maxLen; i++)
			System.out.print(maxStart + i + " ");
	}

	
}
