package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月14日上午12:47:30
 * @timeout 2016年08月14日01:35:27
 */

public class WordLadder2 {
	String alp = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		WordLadder2 wl = new WordLadder2();
		Set<String> wordList = new HashSet<>();
		String[] strs = { "hot", "dot", "dog", "lot", "log" };
		for (String str : strs) {
			wordList.add(str);
		}
		String beginWord = "hit", endWord = "cog";
		System.out.println(wl.ladderLength(beginWord, endWord, wordList));
	}

	public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
		Map<String, Graph> map = new HashMap<>();
		wordList.add(beginWord);
		wordList.add(endWord);
		for (String str : wordList) {
			map.put(str, new Graph(str));
		}
		// System.out.println(map);

		for (String str : wordList) {
			List<String> maybe = getMaybe(str, wordList);
			Graph g=map.get(str);
			for(String s:maybe){
				g.next.add(map.get(s));
			}
		}

		// for (String str : wordList) {
		// Graph g = map.get(str);
		// for (String other : wordList) {
		// if (yes(str, other)) {
		// Graph o = map.get(other);
		// g.next.add(o);
		//// o.next.add(g);
		// }
		// }
		// }

		// System.out.println(map);

		if (map.get(beginWord).next.contains(map.get(endWord)))
			return 2;

		Queue<Graph> queue = new LinkedList<>();
		queue.add(map.get(beginWord));
		map.remove(beginWord);
		int path = 1;
		while (!queue.isEmpty()) {
			// System.out.println("queue: "+queue);
			path++;
			Queue<Graph> tmp = new LinkedList<>();
			while (!queue.isEmpty()) {
				Graph cur = queue.poll();
				for (Graph g : cur.next) {
					if (g.val.equals(endWord))
						return path;
					if (map.containsKey(g.val)) {
						tmp.offer(g);
						map.remove(g.val);
					}
				}
			}
			queue = tmp;
		}

		return -1;
	}

	private List<String> getMaybe(String str, Set<String> wordList) {
		List<String> ret = new LinkedList<>();
		StringBuffer sb = new StringBuffer(str);
		for (int i = 0; i < str.length(); i++) {
			int jump = str.charAt(i) - 'a';
			for (int j = 0; j < 26; j++) {
				if (j == jump)
					continue;
				char cur = alp.charAt(j);
				sb.replace(i, i + 1, cur + "");
				if (wordList.contains(sb.toString()))
					ret.add(sb.toString());
			}
			sb = new StringBuffer(str);
		}

		return ret;
	}

	private boolean yes(String str, String other) {
		if (str.equals(other) || str.length() != other.length())
			return false;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != other.charAt(i))
				count++;

			if (count > 1)
				return false;
		}

		return true;
	}

	class Graph {
		String val;
		List<Graph> next;

		Graph(String val) {
			this.val = val;
			next = new ArrayList<>();
		}

		@Override
		public String toString() {
			return "[val=" + val + ", next=" + next.size() + "]";
		}

	}

}
