//package hou.forwz.Leetcode.hard;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Map;
//import java.util.Set;
//
///**
// * @author houweitao
// * @date 2016年8月2日下午11:48:22
// */
//
//public class WordSearchII2 {
//	Set<String> res = new HashSet<String>();
//
//	public List<String> findWords(char[][] board, String[] words) {
//		Trie trie = new Trie();
//		for (String word : words) {
//			trie.insert(word);
//		}
//
//		int m = board.length;
//		int n = board[0].length;
//		boolean[][] visited = new boolean[m][n];
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				dfs(board, visited, "", i, j, trie);
//			}
//		}
//
//		return new ArrayList<String>(res);
//	}
//
//	public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
//		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
//			return;
//		if (visited[x][y])
//			return;
//
//		str += board[x][y];
//		if (!trie.startsWith(str))
//			return;
//
//		if (trie.search(str)) {
//			res.add(str);
//		}
//
//		visited[x][y] = true;
//		dfs(board, visited, str, x - 1, y, trie);
//		dfs(board, visited, str, x + 1, y, trie);
//		dfs(board, visited, str, x, y - 1, trie);
//		dfs(board, visited, str, x, y + 1, trie);
//		visited[x][y] = false;
//	}
//
////	class Trie {
////		char root;
////		Map<Character, Trie> map;
////
////		Trie() {
////			root = '#';
////			map = new HashMap<>();
////		}
////
////		Trie(char c) {
////			root = c;
////			map = new HashMap<>();
////		}
////
////		public boolean startsWith(String str) {
////			if (str.length() == 0)
////				return true;
////			char c = str.charAt(0);
////			if (map.containsKey(c))
////				return map.get(c).startsWith(str.substring(1));
////			else
////				return false;
////		}
////
////		public void insert(String word) {
////			if (word.length() == 0)
////				return;
////			if (map.containsKey(word.charAt(0)))
////				map.get(word.charAt(0)).insert(word.substring(1));
////			else {
////				Trie trie = new Trie(word.charAt(0));
////				trie.insert(word.substring(1));
////				map.put(word.charAt(0), trie);
////			}
////
////		}
////
////		public boolean search(String str) {
////			// if (str.length() == 1 && root == str.charAt(0))
////			// return true;
////			// else {
////			if(str.length()==0)
////				return false;
////			
////			if (map.containsKey(str.charAt(0)))
////				return map.get(str.charAt(0)).search(str.substring(1));
////			else
////				return false;
////			// }
////		}
////
////	}
//}
