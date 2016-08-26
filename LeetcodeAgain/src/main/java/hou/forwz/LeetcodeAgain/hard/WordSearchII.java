package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月25日下午2:54:31
 */

public class WordSearchII {
	int all = -1;
	boolean end = false;

	public static void main(String[] args) {
		WordSearchII wb = new WordSearchII();
		// wb.init();

		char[][] board = { { 'a' } };
		String[] words = { "a" };
		System.out.println(wb.findWords(board, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie('$');
		for (String str : words)
			root.insert(str);

		all = words.length;

		List<String> ret = new ArrayList<>();
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				dfs(board, i, j, root, ret, "");

		return ret;
	}

	private void dfs(char[][] board, int m, int n, Trie root, List<String> ret, String pre) {
		if (!in(board, m, n) || end)
			return;
		char bak = board[m][n];
		if (bak == '#')
			return;
		int pos = bak - 'a';
		if (root.child[pos] != null) {
			if (root.child[pos].isEnd) {
				String add = pre + bak;
				root.child[pos].isEnd = false;
				ret.add(add);
				if (ret.size() == all)
					end = true;
			}

			board[m][n] = '#';

			dfs(board, m + 1, n, root.child[pos], ret, pre + bak);
			dfs(board, m - 1, n, root.child[pos], ret, pre + bak);
			dfs(board, m, n + 1, root.child[pos], ret, pre + bak);
			dfs(board, m, n - 1, root.child[pos], ret, pre + bak);

			board[m][n] = bak;
		}

	}

	private boolean in(char[][] board, int m, int n) {
		if (m >= 0 && m < board.length && n >= 0 && n < board[0].length)
			return true;
		else
			return false;
	}

	class Trie {
		char val;
		boolean isEnd;
		Trie[] child;

		public Trie(char val) {
			this.val = val;
			child = new Trie[26];
		}

		public void insert(String str) {
			Trie node = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				int pos = c - 'a';

				Trie tmp;
				if (node.child[pos] != null)
					tmp = node.child[pos];
				else {
					tmp = new Trie(c);
					node.child[pos] = tmp;
				}
				node = tmp;
			}
			node.isEnd = true;
		}
	}
}
