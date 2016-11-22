package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年11月22日下午7:46:20
 */

public class WordBreakII4 {
	public static void main(String[] args) {
		WordBreakII4 wb = new WordBreakII4();
		String s = "catsanddog";
		// String s = "ab";

		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("sand");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("dog");

		wordDict.add("a");
		wordDict.add("b");

		System.out.println(wb.wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		Node[] dp = new Node[s.length()];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = new Node();
			String cur = s.substring(0, i + 1);

			if (wordDict.contains(cur)) {
				dp[i].add(cur);
			} else {
				for (int j = 1; j <= i; j++) {
					String may = s.substring(j, i + 1);
					if (dp[j - 1].getSize() > 0 && wordDict.contains(may)) {
						for (String ss : dp[j - 1].list) {
							dp[i].add(ss + " " + may);
						}
					}
				}
			}
		}

//		for (Node node : dp) {
//			System.out.println(node);
//		}
//		System.out.println("---");

		List<String> ret = new ArrayList<>();
		for (String ss : dp[dp.length - 1].list) {
			ret.add(ss.trim());
		}

		return ret;

	}

	class Node {
		List<String> list;

		public Node() {
			list = new ArrayList<>();
		}

		public int getSize() {
			return list.size();
		}

		void add(String str) {
			list.add(str);
		}

		@Override
		public String toString() {
			return list.toString();
		}
	}
}
