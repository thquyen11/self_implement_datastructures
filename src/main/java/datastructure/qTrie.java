package datastructure;

import java.util.HashMap;
import java.util.Map;

public class qTrie {
	private TrieNode root;

	public qTrie() {
		root = new TrieNode(' ');
	}

	public boolean insert(String insert) {
		char[] insertArray = insert.toCharArray();
		TrieNode currentNode = root;

		for (int i = 0; i < insertArray.length; i++) {
			if (currentNode.childList.isEmpty()) {
				TrieNode tempNode = new TrieNode(insertArray[i]);
				currentNode.childList.put(insertArray[i], tempNode);
				currentNode = currentNode.childList.get(insertArray[i]);
			} else {
				if (!currentNode.childList.containsKey(insertArray[i])) {
					TrieNode tempNode = new TrieNode(insertArray[i]);
					currentNode.childList.put(insertArray[i], tempNode);
					currentNode = currentNode.childList.get(insertArray[i]);
				} else {
					currentNode = currentNode.childList.get(insertArray[i]);
				}
			}

			if (i == insertArray.length - 1) {
				currentNode.isWord = true;
			}
		}

		return true;
	}

	public boolean contains(String word) {
		char[] wordArray = word.toCharArray();
		TrieNode currentNode = root;

		for (int i = 0; i < wordArray.length; i++) {
			if (!currentNode.childList.containsKey(wordArray[i])) {
				System.out.printf("%c not existed in the Trie\n", wordArray[i]);
				return false;
			} else {
				currentNode = currentNode.childList.get(wordArray[i]);
			}
		}

		return true;
	}

	public boolean completeWord(String word) {
		char[] wordArray = word.toCharArray();
		TrieNode currentNode = root;

		for (int i = 0; i < wordArray.length; i++) {
			if (!currentNode.childList.containsKey(wordArray[i])) {
				return false;
			} else {
				currentNode = currentNode.childList.get(wordArray[i]);
			}

			if (i == wordArray.length - 1 && currentNode.isWord == false) {
				return false;
			}
		}

		return true;
	}

//	In this algorithm, we keep on passing the level to the child node starting with level 0 for root node. 
//	When this level of the node being looked at matches the length of the key, then we know that the node 
//	currently being looked at corresponds to last character of key 'k'. 
//	In this case, we check if this node has any children. 
//	If it has any children then that means this node must be part of other key(s) as well and hence we cannot delete this node. 
//	We simply mark this node as a 'non leaf node' and return deletedSelf = false to the parent node
//	On the other hand, if this node has no children then we know that this node must be the part of only key 'k', therefore we can safely delete this node. 
//	We delete the node(by marking currentNode as null) and return deletedSelf = true to the parent node.
//	If at any point during the key-path traversal we find out that the currentNode is null then we know that this key was never inserted 
//	and hence we return deletedSelf = false by printing out the appropriate message('Key Not Found').
	public boolean delete(String word, TrieNode current, int index) {
		if (index == word.length()) {
			return current.isWord ? true : false;
		}
		if (current.childList.isEmpty()) {
			System.out.printf("%c is out of Trie's scope\n", word.charAt(index));
			return false;
		}

		if (!current.childList.containsKey(word.charAt(index))) {
			System.out.printf("Character %c not exist in the Trie\n", word.charAt(index));
			return false;
		} else {
			return delete(word, current.childList.get(word.charAt(index++)), index++);
		}
	}

	public TrieNode getRoot() {
		return root;
	}

	public void setRoot(TrieNode root) {
		this.root = root;
	}

	private static class TrieNode {
		char value;
		Map<Character, TrieNode> childList;
		boolean isWord;

		public TrieNode(char value) {
			this.value = value;
			this.childList = new HashMap<>();
			isWord = false;
		}
	}
}
