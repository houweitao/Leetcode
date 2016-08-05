package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月5日下午10:20:25
 */

public class AddAndSearchWord {

	public static void main(String[] args) {
		AddAndSearchWord as = new AddAndSearchWord();
		as.init();
	}

	private void init() {
		WordDictionary wd = new WordDictionary();
		wd.addWord("pad");
		System.out.println(wd.search("p.."));
	}

	class TrieNode {
		char val;
		TrieNode[] next = new TrieNode[26];
		boolean isWord;

		TrieNode() {

		}

		TrieNode(char val) {
			this.val = val;
		}

		// 第一次过来的一定是.
		public boolean search(String word) {
//			System.out.println(val + "," + word);

			if (word.length() == 0)
				return false;
			else if (word.length() == 1) {
				if (word.charAt(0) == '.') {
					for (int i = 0; i < 26; i++) {
						if (next[i] != null && next[i].isWord)
							return true;
					}
					return false;
				} else
					return next[word.charAt(0) - 'a'] != null && next[word.charAt(0) - 'a'].isWord;
			} else {
				char c = word.charAt(0);
				if (c != '.') {
					if (next[c - 'a'] != null) {
						return next[c - 'a'].search(word.substring(1));
					} else
						return false;
				} else {
					for (int i = 0; i < 26; i++) {
						if (next[i] != null && next[i].search(word.substring(1)))
							return true;
					}
					return false;
				}
			}
		}
	}

	public class WordDictionary {
		TrieNode root = new TrieNode();;

		// Adds a word into the data structure.
		public void addWord(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (node.next[c - 'a'] == null)
					node.next[c - 'a'] = new TrieNode(c);

				node = node.next[c - 'a'];
			}
			node.isWord = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (c == '.') {
					return node.search(word.substring(i));
				} else {
					if (node.next[c - 'a'] == null)
						node.next[c - 'a'] = new TrieNode(c);

					node = node.next[c - 'a'];
				}
			}
			return node.isWord;
		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
