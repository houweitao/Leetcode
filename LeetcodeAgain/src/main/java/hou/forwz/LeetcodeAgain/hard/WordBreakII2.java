package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月25日上午12:35:58
 * @timeout 2016年08月25日00:47:02
 */

public class WordBreakII2 {
	public static void main(String[] args) {
		WordBreakII2 wb = new WordBreakII2();
		String s = "catsanddog";
		// String s = "ab";

		Set<String> wordDict = new HashSet<>();
		wordDict.add("a");
		wordDict.add("aa");
		wordDict.add("sand");
		wordDict.add("cats");
		wordDict.add("cat");
		wordDict.add("and");
		wordDict.add("dog");

		System.out.println(wb.wordBreak(s, wordDict));
	}

	public List<String> wordBreak(String s, Set<String> wordDict) {
		List<List<String>> record = new ArrayList<>();

		for (int i = 0; i < s.length(); i++)
			record.add(new ArrayList<String>());

		for (int i = 0; i < s.length(); i++) {
			if (wordDict.contains(s.substring(0, i + 1))) {
				record.get(i).add(s.substring(0, i + 1));
			}
		}

		for (int i = 0; i < s.length(); i++) {
			for (int j = 1; j < s.length()&&j<=i; j++) {
				String cur = s.substring(j, i + 1);
				if (wordDict.contains(cur)) {
					List<String> now = record.get(i);
					List<String> before = record.get(j - 1);
					for (String str : before) {
						now.add((str + " " + cur).trim());
					}
				}
			}
		}

		return record.get(s.length() - 1);
	}

}
