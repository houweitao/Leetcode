package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月10日下午11:42:20
 */

public class SubstringWithConcatenationOfAllWords {
	public static void main(String[] args) {
		SubstringWithConcatenationOfAllWords sw = new SubstringWithConcatenationOfAllWords();
		String[] words = { "word", "good", "best", "good" };
		String s = "wordgoodgoodgoodbestword";
		System.out.println(sw.findSubstring(s, words));
	}

	// 一开始没有读清楚题意，words 的单词长度都是相等的。不过这样更有一般性了
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> ret = new ArrayList<>();
		if (s.length() < 1 || words.length < 1)
			return ret;

		Map<String, Integer> map = new HashMap<>();
		List<Integer> len = new ArrayList<>();
		int max = 0, min = Integer.MAX_VALUE;
		for (int i = 0; i < words.length; i++) {
			if (!map.containsKey(words[i]))
				map.put(words[i], 0);
			map.put(words[i], map.get(words[i]) + 1);

			max = Math.max(max, words[i].length());
			min = Math.min(min, words[i].length());
			if (!len.contains(words.length))
				len.add(words[i].length());
		}

		Collections.sort(len);
		for (int i = 0; i <= s.length() - min; i++) {
			Map<String, Integer> curMap = new HashMap<>(map);
			if (dfs(s, i, curMap, len))
				ret.add(i);
		}

		return ret;

	}

	private boolean dfs(String s, int pos, Map<String, Integer> map, List<Integer> len) {
		// System.out.println(pos + ", " + map);
		for (int i = 0; i < len.size(); i++) {
			int chang = len.get(i);
			if (pos + chang <= s.length()) {
				String str = s.substring(pos, pos + chang);
				if (map.containsKey(str)) {
					int bak = map.get(str);
					if (bak == 1) {
						map.remove(str);
					} else
						map.put(str, bak - 1);

					if (map.size() == 0)
						return true;
					if (dfs(s, pos + chang, map, len)) {
						return true;
					}
					map.put(str, bak);
				}
			}
		}

		return false;
	}

	public static List<Integer> findSubstringBetter(String s, String[] words) {
		List<Integer> res = new ArrayList<Integer>();
		if (s == null || words == null || words.length == 0)
			return res;
		int len = words[0].length(); // length of each word

		Map<String, Integer> map = new HashMap<String, Integer>(); // map for L
		for (String w : words)
			map.put(w, map.containsKey(w) ? map.get(w) + 1 : 1);

		for (int i = 0; i <= s.length() - len * words.length; i++) {
			Map<String, Integer> copy = new HashMap<String, Integer>(map);
			for (int j = 0; j < words.length; j++) { // checkc if match
				String str = s.substring(i + j * len, i + j * len + len); // next
																			// word
				if (copy.containsKey(str)) { // is in remaining words
					int count = copy.get(str);
					if (count == 1)
						copy.remove(str);
					else
						copy.put(str, count - 1);
					if (copy.isEmpty()) { // matches
						res.add(i);
						break;
					}
				} else
					break; // not in L
			}
		}
		return res;
	}

	public List<Integer> findSubstringOther(String s, String[] words) {
		List<Integer> result = new ArrayList<>();
		int size = words[0].length();
		if (words.length == 0 || words[0].isEmpty() || words[0].length() > s.length())
			return result;
		Map<String, Integer> hist = new HashMap<>();
		for (String w : words) {
			hist.put(w, !hist.containsKey(w) ? 1 : hist.get(w) + 1);
		}
		for (int i = 0; i + size * words.length <= s.length(); i++) {
			if (hist.containsKey(s.substring(i, i + size))) {
				Map<String, Integer> currHist = new HashMap<>();
				for (int j = 0; j < words.length; j++) {
					String word = s.substring(i + j * size, i + (j + 1) * size);
					currHist.put(word, !currHist.containsKey(word) ? 1 : currHist.get(word) + 1);
				}
				if (currHist.equals(hist))
					result.add(i);
			}
		}
		return result;
	}

}
