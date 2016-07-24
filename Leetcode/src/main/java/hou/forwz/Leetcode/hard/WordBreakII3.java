package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月25日上午12:00:42
 */

public class WordBreakII3 {

	HashMap<String, List<String>> map = new HashMap<String, List<String>>();

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

	public List<String> wordBreak(String s, Set<String> dict) {
		if (map.containsKey(s))
			return map.get(s);

		List<String> ret = new LinkedList<>();

		if (dict.contains(s))
			ret.add(s);
		for (int i = 0; i < s.length(); i++) {
			if (dict.contains(s.substring(0, i + 1))) {
				List<String> next = wordBreak(s.substring(i + 1), dict);
				for (String str : next) {
					ret.add(s.substring(0, i + 1) + " " + str);
				}
			}
		}
		map.put(s, ret);
		return ret;
	}
}
