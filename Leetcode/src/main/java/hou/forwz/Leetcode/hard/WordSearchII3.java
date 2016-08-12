package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月13日上午1:40:25
 */

public class WordSearchII3 {
	Set<String> set = new HashSet<>();

	public static void main(String[] args) {
		WordSearchII3 wb = new WordSearchII3();
		// wb.init();

		char[][] board = { { 'a', 'b' }, { 'a', 'a' } };
		String[] words = { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" };
		System.out.println(wb.findWords(board, words));
	}

	private void init() {
		Trie root = new Trie();
		// buildTrie(root, "abcd");
		String[] words = { "aba", "baa", "bab", "aaab", "aaa", "aaaa", "aaba" };
		for (String str : words) {
			buildTrie(root, str);
			System.out.println(str + "," + root.startWith(str));

		}

		System.out.println(root.child[0].head);

		System.out.println(root.startWith("ab"));
		System.out.println(root.contains("abc"));
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for (String str : words) {
			buildTrie(root, str);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				dfs(board, i, j, visited, root, "");
			}
		}

		List<String> ret = new ArrayList<>(set.size());

		for (String str : set)
			ret.add(str);

		return ret;

	}

	private void dfs(char[][] board, int i, int j, boolean[][] visited, Trie root, String before) {
		if (!in(board, i, j))
			return;

		if (visited[i][j])
			return;

		String cur = before + board[i][j];

		if (root.contains(cur)) {
			set.add(cur);
			// return; //这里不能 return，因为可能有 aaa，aaab 这种情况 2016年08月13日02:29:25
		}

		if (root.startWith(cur)) {
			visited[i][j] = true;

			dfs(board, i + 1, j, visited, root, cur);
			dfs(board, i - 1, j, visited, root, cur);
			dfs(board, i, j + 1, visited, root, cur);
			dfs(board, i, j - 1, visited, root, cur);

			visited[i][j] = false;
		}

	}

	private boolean in(char[][] board, int i, int j) {
		if (i >= 0 && i < board.length && j >= 0 && j < board[0].length)
			return true;
		else
			return false;
	}

	void buildTrie(Trie root, String str) {
		Trie node = root;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			Trie cur;
			if (node.child[c - 'a'] != null)
				cur = node.child[c - 'a'];
			else {
				cur = new Trie(c);
				node.child[c - 'a'] = cur;
			}
			node = cur;
		}
		node.end = true;
	}

	class Trie {
		char head;
		Trie[] child = new Trie[26];
		boolean end;

		Trie() {
			head = '#';
		}

		Trie(char c) {
			head = c;
		}

		boolean startWith(String str) {
			if (str.length() == 0)
				return false;
			Trie node = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (node.child[c - 'a'] == null)
					return false;

				node = node.child[c - 'a'];
			}
			return true;
		}

		boolean contains(String str) {
			if (str.length() == 0)
				return false;
			Trie node = this;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (node.child[c - 'a'] == null)
					return false;

				node = node.child[c - 'a'];
			}

			return node.end;
		}
	}
}
