package hou.forwz.Leetcode.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月18日下午11:53:33 有点像硬币的那个题目
 */

public class WordBreak {
	Set<Integer> set = new HashSet<Integer>();

	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		String s = "aaa";
		Set<String> wordDict = new HashSet<>();
		wordDict.add("aaaa");
		wordDict.add("aa");
		System.out.println(wb.wordBreak(s, wordDict));
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
		boolean[] can = new boolean[s.length() + 1];
		can[0] = true;

		for (int i = 1; i < s.length() + 1; i++) {
			for (int j = 0; j < i; j++) {
				if (can[j] && wordDict.contains(s.substring(j, i))) {
					can[i] = true;
					break;
				}
			}
		}
		return can[s.length()];
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		if (s == null)
			return true;
		if (wordDict.size() == 0)
			return false;
		return help(s, 0, s.length() - 1, wordDict);
	}

	private boolean help(String s, int begin, int end, Set<String> wordDict) {
		if (begin > end)
			return true;
		else if (begin == end) {
			return wordDict.contains(s.charAt(begin) + "");
		} else {
			for (int i = end - 1; i >= begin; i--) {

				if (wordDict.contains(s.substring(begin, i + 1))) {
					if (help(s, i + 1, end, wordDict)) {
						return true;
					} else
						set.add(i + 1);
				}

			}

			if (wordDict.contains(s.substring(begin, end + 1))) {
				return true;
			}

			return false;
		}

	}

}
