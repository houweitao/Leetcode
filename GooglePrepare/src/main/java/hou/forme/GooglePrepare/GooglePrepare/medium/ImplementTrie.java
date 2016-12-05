package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:38:08
 */

public class ImplementTrie {

	public static void main(String[] args) {
		new ImplementTrie().init();
	}

	private void init() {
		Trie trie = new Trie();
		trie.insert("hello");
		System.out.println(trie.startsWith("hell"));
	}

	class TrieNode {
		// Initialize your data structure here.
		char val;

		public TrieNode() {

		}

		public TrieNode(char c) {
			this.val = c;
		}
	}

	public class Trie {
		private Trie[] childs;
		boolean isWord;

		public Trie() {
			childs = new Trie[26];
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				if (node.childs[pos] == null)
					node.childs[pos] = new Trie();
				node = node.childs[pos];
			}
			node.isWord = true;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			Trie node = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				if (node.childs[pos] == null)
					return false;
				else {
					node = node.childs[pos];// TODO 这里写成了i， 细心细心！
				}
			}
			return node.isWord;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			Trie node = this;
			for (int i = 0; i < prefix.length(); i++) {
				int pos = prefix.charAt(i) - 'a';
				if (node.childs[pos] == null)
					return false;
				else {
					node = node.childs[pos];
				}
			}

			if (node.isWord)
				return true;
			for (int i = 0; i < 26; i++) {
				if (node.childs[i] != null)
					return true;
			}
			return false;
		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
