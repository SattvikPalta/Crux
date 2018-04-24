package July30;

public class TrieClient {

	public static void main(String[] args) {
		Trie trie = new Trie();
		
		trie.addWord("and");
		trie.addWord("ant");
		trie.addWord("art");
		trie.addWord("arc");
		
		trie.addWord("but");
		trie.addWord("bug");
		trie.addWord("buy");
		
		trie.addWord("sea");
		trie.addWord("seen");
		
		System.out.println(trie.searchWord("arc"));
		
		System.out.println(trie.searchWord("army"));

		System.out.println(trie.searchWord("see"));
		
		System.out.println(trie.searchWord("bug"));
		
		trie.display();
		
		trie.removeWord("arc");
		
		trie.removeWord("but");

		System.out.println("-------------------");
		trie.display();
	}

}
