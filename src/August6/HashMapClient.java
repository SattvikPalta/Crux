package August6;

public class HashMapClient {

	public static void main(String[] args) throws Exception {
		HashMap<String, Integer> hm = new HashMap<>();
		
		hm.put("India", 200);
		hm.put("China", 250);
		hm.put("US", 150);
		hm.put("UK", 100);
		hm.put("Germany", 60);
		
		hm.display();
		
		hm.put("Russia", 125);
		hm.put("Brazil", 80);
		hm.put("Spain", 70);
		hm.put("France", 60);
		
		hm.display();
		
		System.out.println(hm.containsKey("US"));
		
		System.out.println(hm.get("China"));
		
		System.out.println(hm.remove("UK"));
	}

}
