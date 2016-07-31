package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月1日上午12:53:31
 */

public class MaximumProductOfWordLengths {

	public int maxProduct(String[] words) {
		if(words.length<2)
			return 0;
		
		Map<String, int[]> map = uniform(words);

		int max = 0;

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				max = Math.max(max, multi(words[i], words[j], map));
			}
		}
		return max;
	}

	private int multi(String left, String right, Map<String, int[]> map) {
		int[] a = map.get(left);
		int[] b = map.get(right);

		for (int i = 0; i < 26; i++) {
			if (a[i] != 0 && b[i] != 0)
				return 0;
		}

		return left.length() * right.length();
	}

	private Map<String, int[]> uniform(String[] words) {
		Map<String, int[]> ret = new HashMap<>();
		for (String str : words) {
			int[] cur = new int[26];
			for (int i = 0; i < str.length(); i++) {
				int pos = str.charAt(i) - 'a';
				cur[pos]++;
			}

			ret.put(str, cur);
		}
		return ret;
	}

}
