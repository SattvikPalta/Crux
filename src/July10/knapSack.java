package July10;

public class knapSack {

	public static void main(String[] args) {
		int[] price = { 10, 15, 20, 5, 8 };
		int[] weight = { 20, 15, 15, 5, 8 };
		System.out.println(knapSack(price, weight, 50, 0));
	}

	public static int knapSack(int[] price, int[] weight, int capacity, int vidx) {
		if (vidx == weight.length)
			return 0;

		int include = 0, exclude = 0;
		
		if (weight[vidx] <= capacity)
			include = price[vidx] + knapSack(price, weight, capacity - weight[vidx], vidx + 1);

		exclude = knapSack(price, weight, capacity, vidx + 1);
		
		return Math.max(include, exclude);
	}
}
