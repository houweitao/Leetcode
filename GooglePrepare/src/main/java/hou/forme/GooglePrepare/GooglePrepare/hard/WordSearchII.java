package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:52:27
 * @end 2016年12月05日22:04:22
 */

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for (String str : words) {
			root.insert(str);
		}

		List<String> ret = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, root, ret, "");
			}
		}
		return ret;
	}

	private void dfs(char[][] board, int i, int j, Trie root, List<String> ret, String pre) {
		if (root.isWord) {
			ret.add(pre);
			root.isWord = false;
		}
		if (!yes(board, i, j) || board[i][j] == '$')
			return;
		char tmp = board[i][j];
		int pos = board[i][j] - 'a';
		if (root.childs[pos] != null) {
			board[i][j] = '$';
			dfs(board, i + 1, j, root.childs[pos], ret, pre + tmp);
			dfs(board, i - 1, j, root.childs[pos], ret, pre + tmp);
			dfs(board, i, j + 1, root.childs[pos], ret, pre + tmp);
			dfs(board, i, j - 1, root.childs[pos], ret, pre + tmp);
			board[i][j] = tmp;
		}

	}

	private boolean yes(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		else
			return false;
	}

	class Trie {
		Trie[] childs;
		boolean isWord;

		public Trie() {
			childs = new Trie[26];
		}

		void insert(String word) {
			Trie trie = this;
			char[] ch = word.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				int pos = ch[i] - 'a';
				if (trie.childs[pos] == null)
					trie.childs[pos] = new Trie();

				trie = trie.childs[pos];
			}
			trie.isWord = true;
		}
	}
}
