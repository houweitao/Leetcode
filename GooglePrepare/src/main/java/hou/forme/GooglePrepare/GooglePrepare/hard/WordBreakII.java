package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月5日下午8:25:02
 */

public class WordBreakII {
	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String[] dict = { "a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa",
				"aaaaaaaaaa" };
		Set<String> set = new HashSet<>();
		for (String ss : dict)
			set.add(ss);

		List<String> ret = new WordBreakII().wordBreak(s, set);
		for (String sss : ret)
			System.out.println(sss);
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		Node[] nodes = new Node[s.length()];
		Set<Integer> set = new HashSet<>();
		for (String str : wordDict)
			set.add(str.length());

		for (int i = 0; i < s.length(); i++) {
			nodes[i] = new Node();
			for (int j : set) {
				if (i >= j - 1) {
					if (i == j - 1) {
						if (wordDict.contains(s.substring(0, i + 1)))
							nodes[i].list.add(s.substring(0, i + 1));
					} else {
						if (nodes[i - j].list.size() > 0 && wordDict.contains(s.substring(i - j + 1, i + 1))) {
							for (String ss : nodes[i - j].list) {
								nodes[i].list.add(ss + " " + s.substring(i - j + 1, i + 1));
							}
						}
					}
				}
			}

			System.out.println(i + ": " + nodes[i].list.size());
			// for (String sss : nodes[i].list) {
			// System.out.println(i + ": " + sss);
			// }
		}

		return nodes[s.length() - 1].list;
	}

	class Node {
		List<String> list;

		public Node() {
			list = new ArrayList<>();
		}
	}
}
