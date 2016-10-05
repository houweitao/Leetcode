package hou.forwz.LeetcodeAgain.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月30日下午7:31:43
 */

public class WordBreak {
	public static void main(String[] args) {
		WordBreak wb = new WordBreak();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("leet");
		wordDict.add("code");
		System.out.println(wb.wordBreak2("leetcode", wordDict));
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
		boolean[] yes = new boolean[s.length() + 1];
		yes[0] = true;

		for (int i = 1; i <= s.length(); i++) {
			if (wordDict.contains(s.substring(0, i))) {
				yes[i] = true;
			} else {
				for(String str:wordDict){
					if(i>str.length()){
						if(yes[i-str.length()]){
							String cur = s.substring(i-str.length(), i);
							if (wordDict.contains(cur))
								yes[i] = true;
						}
					}
				}
//				for (int j = 1; j < i; j++) {
//					if (yes[j]) {
//						String cur = s.substring(j, i);
//						if (wordDict.contains(cur))
//							yes[i] = true;
//					}
//				}
			}
		}

		return yes[s.length()];
	}

	// time out
	public boolean wordBreak(String s, Set<String> wordDict) {
		if (wordDict.contains(s))
			return true;

		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (String str : wordDict) {
			min = Math.min(min, str.length());
			max = Math.max(max, str.length());
		}

		return help(s, wordDict, min, max);
	}

	private boolean help(String s, Set<String> wordDict, int min, int max) {
		if (wordDict.contains(s))
			return true;
		if (s.length() < min)
			return false;
		for (int i = min; i <= max && i <= s.length(); i++) {
			String cur = s.substring(0, i);
			if (wordDict.contains(cur)) {
				if (wordBreak(s.substring(i), wordDict))
					return true;
			}
		}
		return false;
	}
}