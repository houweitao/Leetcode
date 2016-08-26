package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月25日上午11:29:05
 */

public class WordBreakII3 {
	Map<String, List<String>> map = new HashMap<>();

	public static void main(String[] args) {
		WordBreakII3 wb = new WordBreakII3();
		String s = "catsanddog";
		// String s = "ab";

		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("sand");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("dog");

		System.out.println(wb.wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		return dfs(s, wordDict);
	}

	private List<String> dfs(String s, Set<String> wordDict) {
//		System.out.println(s);
		
		if (map.containsKey(s))
			return map.get(s);
		else {
			List<String> ret = new ArrayList<>();

			if (wordDict.contains(s))
				ret.add(s);

			for (String str : wordDict) {
				if (s.startsWith(str) && !s.equals(str)) {
					List<String> next = dfs(s.substring(str.length()), wordDict);

					for (String ns : next) {
						ret.add(str + " " + ns);
					}

				}
			}

			map.put(s, ret);
			return ret;
		}

	}
}
