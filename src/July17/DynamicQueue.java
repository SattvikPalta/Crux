package July17;

public class DynamicQueue extends Queue {
	@Override
	public void enqueue(int value) throws Exception {
		if (this.size == data.length - 1) {
			int[] oa = this.data;
			int[] na = new int[this.data.length * 2];
			
			for (int i = 0; i < size; i++) {
				na[i] = oa[(front + i) % data.length];
			}
			this.front = 0;
			this.data = na;
		}
		super.enqueue(value);
	}
}
