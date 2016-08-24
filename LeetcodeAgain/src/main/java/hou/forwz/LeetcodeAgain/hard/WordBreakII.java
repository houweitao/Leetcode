package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月25日上午12:04:19
 */

public class WordBreakII {
	public static void main(String[] args) {
		WordBreakII wb = new WordBreakII();
		String s = "aaaa";
		// String s = "ab";

		Set<String> wordDict = new HashSet<>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("sand");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("dog");

		System.out.println(wb.wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<String> ret = new ArrayList<>();
		dfs(s, 0, wordDict, "", ret);
		return ret;
	}

	private void dfs(String s, int pos, Set<String> wordDict, String pre, List<String> ret) {
		if (pos == s.length()) {
			ret.add(pre.trim());
			return;
		}
		String last = s.substring(pos);
		if (wordDict.contains(last)) {
			String add = pre + " " + last;
			ret.add(add.trim());
		}

		for (int i = pos; i < s.length()-1; i++) {
			String cur = s.substring(pos, i + 1);
			System.out.println("cur: "+cur);
			if (wordDict.contains(cur)) {
				dfs(s, i + 1, wordDict, pre + " " + cur, ret);
			}
		}

	}

}
