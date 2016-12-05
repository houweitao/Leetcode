package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月5日下午8:01:50
 * @end 2016年12月05日20:12:10
 * @tips 边界条件..
 */

public class WordBreak {
	public static void main(String[] args) {
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(new WordBreak().wordBreak2("leetcode", wordDict));
	}

	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] dp = new boolean[s.length()];
		Set<Integer> len = new HashSet<>();
		for (String str : wordDict)
			len.add(str.length());

		for (int i = 0; i < s.length(); i++) {
			for (int j : len) {
				if (i >= j - 1 && (i == j - 1 || dp[i - j]) && wordDict.contains(s.substring(i - j + 1, i + 1))) {
					dp[i] = true;
				}
			}
		}

		return dp[s.length() - 1];
	}

	Map<String, Boolean> map = new HashMap<>();

	public boolean wordBreak2(String s, Set<String> wordDict) {
		Set<Integer> len = new HashSet<>();
		for (String str : wordDict)
			len.add(str.length());
		System.out.println(len);
		return help(s, wordDict, len);
	}

	private boolean help(String s, Set<String> wordDict, Set<Integer> len) {
		if (map.containsKey(s))
			return map.get(s);
		if (s.length() == 0 || wordDict.contains(s))
			return true;
		for (int i : len) {
			if (s.length() >= i) {
				String cur = s.substring(0, i);
				if (wordDict.contains(cur)) {
					boolean next = help(s.substring(i), wordDict, len);
					if (next) {
						map.put(s, true);
						return true;
					}
				}
			}
		}
		map.put(s, false);
		return false;
	}
}
