package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月11日上午12:53:46
 */

public class SubstringWithConcatenationOfAllWords2 {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords2 sw = new SubstringWithConcatenationOfAllWords2();
		String[] words = { "word", "good", "best", "good" };
		String s = "wordgoodgoodgoodbestword";
		System.out.println(sw.findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		if (s.length() < 1 || words.length < 1)
			return ret;

		Map<String, Integer> map = new HashMap<>();
		int len = 0;
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i]))
				map.put(words[i], 0);
			map.put(words[i], map.get(words[i]) + 1);
			len = words[i].length();
		}
		for (int i = 0; i <= s.length() - len * map.size(); i++) {
			Map<String, Integer> curMap = new HashMap<>(map);
			if (dfs(s, i, curMap, len))
				ret.add(i);
		}

		return ret;

	}

	private boolean dfs(String s, int pos, Map<String, Integer> map, int len) {
		// System.out.println(pos + ", " + map);
		if (pos + len * map.size() > s.length())
			return false;

		String next = s.substring(pos, pos + len);
		if (map.containsKey(next)) {
			int num = map.get(next);
			if (num == 1)
				map.remove(next);
			else
				map.put(next, num - 1);

			if (map.size() == 0)
				return true;

			if (dfs(s, pos + len, map, len))
				return true;
		}
		return false;
	}
}
