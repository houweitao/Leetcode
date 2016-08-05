package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月5日下午9:26:26
 * @bad
 */

public class ImplementTrie {
	class TrieNode {
		// Initialize your data structure here.

		char val;
		Map<Character, TrieNode> childs;
		boolean isWord;

		public TrieNode() {
			val = '#';
			childs = new HashMap<>();
		}

		public TrieNode(char val) {
			this.val = val;
			childs = new HashMap<>();
		}
	}

	public class Trie {
		private TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!node.childs.containsKey(c)) {
					node.childs.put(c, new TrieNode(c));
				}
				node = node.childs.get(c);
			}
			node.isWord = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!node.childs.containsKey(c)) {
					return false;
				}
				node = node.childs.get(c);
			}
			return node.isWord;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {

			TrieNode node = root;
			for (int i = 0; i < prefix.length(); i++) {
				char c = prefix.charAt(i);
				if (!node.childs.containsKey(c)) {
					return false;
				}
				node = node.childs.get(c);
			}
			return true;

		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
