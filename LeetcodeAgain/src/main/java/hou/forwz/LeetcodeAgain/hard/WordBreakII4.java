package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author houweitao
 * @date 2016年8月25日上午11:41:18
 */

public class WordBreakII4 {

	Map<String, List<String>> map = new HashMap<>();

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

		System.out.println(wb.wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		Map<Integer, Integer> map = new TreeMap<>();
		for (String str : wordDict)
			map.put(str.length(), 1);

		int[] len = new int[map.size()];
		int i = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			len[i++] = entry.getKey();
		}

		return dfs(s, wordDict, len);
	}

	private List<String> dfs(String s, Set<String> wordDict, int[] len) {
//		 System.out.println(s);

		if (map.containsKey(s))
			return map.get(s);
		else {
			List<String> ret = new ArrayList<>();

			if (wordDict.contains(s))
				ret.add(s);

			for (int i = 0; i < len.length; i++) {
				int length = len[i];
				if (s.length() > length && wordDict.contains(s.substring(0, length))) {
					List<String> next = dfs(s.substring(length), wordDict, len);

					for (String ns : next) {
						ret.add(s.substring(0, length) + " " + ns);
					}
				}
			}

			map.put(s, ret);
			return ret;
		}

	}

}
