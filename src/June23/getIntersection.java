package June23;

import java.util.ArrayList;

public class getIntersection {

	public static void main(String[] args) {
		Integer[] one = { 1, 1, 2, 2, 2, 3, 5 };
		Integer[] two = { 1, 1, 1, 2, 2, 4, 5 };

		ArrayList<Integer> inter = getIntersection(one, two);
		System.out.println(inter);
	}

	public static ArrayList<Integer> getIntersection(Integer[] one, Integer[] two) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0;
		int j = 0;
		while (i < one.length && j < two.length) {
			if (one[i] < two[j]) {
				i++;
			} else if (one[i] > two[j]) {
				j++;
			} else {
				list.add(one[i]);
				i++;
				j++;
			}
		}
		return list;
	}
}