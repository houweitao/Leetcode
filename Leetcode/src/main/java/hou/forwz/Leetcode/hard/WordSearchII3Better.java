package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月13日上午2:40:18
 */

public class WordSearchII3Better {

	List<String> ret = new ArrayList<>();

	public static void main(String[] args) {
		WordSearchII3Better wb = new WordSearchII3Better();
		// wb.init();

		char[][] board = { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = { "oath", "pea", "eat", "rain" };

		System.out.println(wb.findWords(board, words));
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie root = new Trie();
		for (String str : words) {
			buildTrie(root, str);
		}

		boolean[][] visited = new boolean[board.length][board[0].length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				char c = board[i][j];
				if (root.child[c - 'a'] != null)
					dfs(board, i, j, visited, root, "");
			}
		}

		return ret;

	}

	private void dfs(char[][] board, int i, int j, boolean[][] visited, Trie root, String before) {
		if (root == null)
			return;
		if (root.end) {
			ret.add(before);
			root.end = false;
		}

		if (!in(board, i, j))
			return;

		if (visited[i][j])
			return;

		// System.out.println(root.head +","+board[i][j]);

		if (true) {
			// System.out.println("?");
			String cur = before + board[i][j];
			visited[i][j] = true;

			dfs(board, i + 1, j, visited, root.child[board[i][j] - 'a'], cur);
			dfs(board, i - 1, j, visited, root.child[board[i][j] - 'a'], cur);
			dfs(board, i, j + 1, visited, root.child[board[i][j] - 'a'], cur);
			dfs(board, i, j - 1, visited, root.child[board[i][j] - 'a'], cur);

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

		// boolean startWith(String str) {
		// if (str.length() == 0)
		// return false;
		// Trie node = this;
		// for (int i = 0; i < str.length(); i++) {
		// char c = str.charAt(i);
		// if (node.child[c - 'a'] == null)
		// return false;
		//
		// node = node.child[c - 'a'];
		// }
		// return true;
		// }

		// boolean contains(String str) {
		// if (str.length() == 0)
		// return false;
		// Trie node = this;
		// for (int i = 0; i < str.length(); i++) {
		// char c = str.charAt(i);
		// if (node.child[c - 'a'] == null)
		// return false;
		//
		// node = node.child[c - 'a'];
		// }
		//
		// return node.end;
		// }
	}

}
