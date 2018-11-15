package datastructure;

public class test_qTrie {

	public static void main(String[] args) {
		qTrie trie = new qTrie();
		trie.insert("HELLO");
		trie.insert("HOME");
		trie.insert("DAD");
		trie.insert("DUMB");
		
		System.out.println(trie.contains("HELL")); //true
		System.out.println(trie.contains("HELLON")); //false
		System.out.println("-----------------");
		System.out.println(trie.completeWord("HOM")); //false
		System.out.println(trie.completeWord("HOME")); //true
		System.out.println("-----------------");
		System.out.println(trie.delete("HOMD", trie.getRoot(), 0)); // false
		System.out.println(trie.delete("HOME", trie.getRoot(), 0)); // true

	}

}
