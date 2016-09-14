package hou.forwz.LeetcodeAgain.medium;

/**
 * @author houweitao
 * @date 2016年9月14日下午2:09:06
 */

public class ImplementTrie {
	class TrieNode {
		// Initialize your data structure here.
		public TrieNode() {

		}
	}

	public static void main(String[] args) {
		ImplementTrie it = new ImplementTrie();
		it.test();
	}

	private void test() {
		Trie trie = new Trie();
		trie.insert("ab");
		System.out.println(trie.search("ab"));
		System.out.println(trie.startsWith("a"));
	}

	public class Trie {
		// private TrieNode root;
		char c;
		Trie[] child;
		boolean isEnd;

		public Trie() {
			// root = new TrieNode();
			c='$';
			child = new Trie[26];
		}

		public Trie(char c) {
			// root = new TrieNode();
			this.c = c;
			child = new Trie[26];
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			if (word == null || word.length() == 0)
				return;
			else {
				Trie tri = this;
				for (int i = 0; i < word.length(); i++) {
					char c = word.charAt(i);
					if (tri.child[c - 'a'] == null)
						tri.child[c - 'a'] = new Trie(c);
					tri = tri.child[c - 'a'];
				}
//				System.out.println(tri.c + "," + tri.isEnd);
				tri.isEnd = true;
//				System.out.println(tri.c + "," + tri.isEnd);

			}
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			if (word == null || word.length() == 0)
				return true;
			else {
				Trie tri = this;
//				System.out.println("beginSearch: "+tri.c);
				for (int i = 0; i < word.length(); i++) {
					int pos = word.charAt(i) - 'a';
					if (tri.child[pos] == null)
						return false;
					tri = tri.child[pos];
				}
				
//				System.out.println("have?"+tri.c);
				
				if (tri.isEnd)
					return true;
				else
					return false;
			}
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String word) {

			if (word == null || word.length() == 0)
				return true;
			else {
				Trie tri = this;
				for (int i = 0; i < word.length(); i++) {
					int pos = word.charAt(i) - 'a';
					if (tri.child[pos] == null)
						return false;
					tri = tri.child[pos];
				}
				return true;
			}

		}
	}

	// Your Trie object will be instantiated and called as such:
	// Trie trie = new Trie();
	// trie.insert("somestring");
	// trie.search("key");
}
