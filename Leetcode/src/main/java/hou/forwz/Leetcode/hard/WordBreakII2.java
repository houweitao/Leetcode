package hou.forwz.Leetcode.hard;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月24日下午11:18:22
 */

public class WordBreakII2 {

	public static void main(String[] args) {
		WordBreakII2 wb = new WordBreakII2();
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
		if (s.length() == 0)
			return new LinkedList<>();

		List<List<String>> dp = new LinkedList<>();

		int max = Integer.MIN_VALUE;
		for (String str : wordDict)
			max = Math.max(str.length(), max);

		for (int i = 0; i < s.length(); i++) {
			List<String> tmp = new LinkedList<>();
			dp.add(tmp);
		}

		for (int i = 0; i < s.length(); i++) {
			List<String> list = dp.get(i);

			if (wordDict.contains(s.substring(0, i + 1))) {
				// System.out.println("add" + s.substring(0, i + 1));
				dp.get(i).add(s.substring(0, i + 1));
			}

			for (int j = 0; j < max && j < i; j++) {
				String cur = s.substring(i - j, i + 1);
				if (wordDict.contains(cur)) {
					// System.out.println("contains " + cur + " (" + j + "," + i
					// + ")");
					List<String> jj = dp.get(i - j - 1);
					// System.out.println("before: "+jj);
					if (jj.size() != 0) {
						for (String str : jj) {
							list.add(str + " " + cur);
						}
					}
				}
			}

			// for (int j = 1; j <= i; j++) {
			// String cur = s.substring(j, i + 1);
			// if (wordDict.contains(cur)) {
			// // System.out.println("contains " + cur + " (" + j + "," + i
			// // + ")");
			// List<String> jj = dp.get(j - 1);
			// // System.out.println("before: "+jj);
			// if (jj.size() != 0) {
			// for (String str : jj) {
			// list.add(str + " " + cur);
			// }
			// }
			// }
			// }
		}

		System.out.println(dp);

		return dp.get(dp.size() - 1);

	}

}
