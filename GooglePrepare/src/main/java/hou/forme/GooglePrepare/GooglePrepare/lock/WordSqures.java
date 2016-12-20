package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月19日下午2:23:23
 * @end 2016年12月19日14:50:31
 */

public class WordSqures {
	public static void main(String[] args) {
		String[] words = { "area", "lead", "wall", "lady", "ball" ,"b"};
		WordSqures ws = new WordSqures();
		System.out.println(ws.wordSquares(words));
	}

	public List<List<String>> wordSquares(String[] words) {
		List<List<String>> ret = new ArrayList<>();

		Trie root = new Trie('#');
		for (String str : words) {
			root.insert(str);
		}

		List<String> tmp = new ArrayList<>();
		for (String str : words) {
			tmp.add(str);
			root.makeNoSense(str);
			make(str.length(), ret, root, tmp);
			root.makeSense(str);
			tmp.remove(tmp.size() - 1);
		}

		return ret;
	}

	private void make(int len, List<List<String>> ret, Trie root, List<String> tmp) {
		if (tmp.size() == len) {
			ret.add(new ArrayList<>(tmp));
			return;
		}

		List<String> may = root.startWith(generatePre(tmp));
		for (String next : may) {
			tmp.add(next);
			root.makeNoSense(next);

			make(len, ret, root, tmp);

			root.makeSense(next);
			tmp.remove(tmp.size() - 1);
		}

	}

	private String generatePre(List<String> tmp) {
		int index = tmp.size();
		StringBuilder sb = new StringBuilder();
		for (String str : tmp) {
			sb.append(str.charAt(index));
		}
		return sb.toString();
	}

	class Trie {
		char val;
		Trie[] child;
		boolean isWord;

		public Trie(char val) {
			this.val = val;
			child = new Trie[26];
		}

		void insert(String word) {
			if (word == null || word.length() == 0)
				return;

			Trie trie = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				if (trie.child[pos] == null)
					trie.child[pos] = new Trie(word.charAt(i));
				trie = trie.child[pos];
			}
			trie.isWord = true;
		}

		List<String> startWith(String pre) {
			List<String> ret = new ArrayList<>();
			if (pre == null || pre.length() == 0)
				return ret;

			Trie trie = this;

			for (int i = 0; i < pre.length(); i++) {
				int pos = pre.charAt(i) - 'a';
				if (trie.child[pos] == null)
					return ret;
				trie = trie.child[pos];
			}

			deal(trie, pre, ret);
			return ret;
		}

		private void deal(Trie trie, String pre, List<String> ret) {
			if (trie.isWord) {
				ret.add(pre);
			}
			for (int i = 0; i < 26; i++) {
				if (trie.child[i] != null) {
					deal(trie.child[i], pre + trie.child[i].val, ret);
				}
			}
		}

		void makeNoSense(String word) {
			if (word == null || word.length() == 0)
				return;

			Trie trie = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				trie = trie.child[pos];
			}
			trie.isWord = false;
		}

		void makeSense(String word) {
			if (word == null || word.length() == 0)
				return;

			Trie trie = this;
			for (int i = 0; i < word.length(); i++) {
				int pos = word.charAt(i) - 'a';
				trie = trie.child[pos];
			}
			trie.isWord = true;
		}
	}
}
