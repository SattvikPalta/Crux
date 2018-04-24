package August13;

public class HuffmanClient {

	public static void main(String[] args) {
		HEncoder data = new HEncoder("aaaaaaaaaaaaaaaaaaaaaaaaaabbbbbbbbbbcccccdd");
		
		System.out.println(data.compress("aabbcd"));
		System.out.println(data.decompress("110101001000"));
	}

}
