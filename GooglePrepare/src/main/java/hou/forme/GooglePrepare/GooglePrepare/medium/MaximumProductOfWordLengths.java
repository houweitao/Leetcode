package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月7日上午1:09:50
 */

public class MaximumProductOfWordLengths {
	public int maxProduct(String[] words) {
		Map<String, boolean[]> map = new HashMap<>();
		for (String str : words) {
			map.put(str, fingerPrint(str));
		}

		int max = 0;
		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				if (yes(map.get(words[i]), map.get(words[j]))) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		return max;
	}

	private boolean yes(boolean[] a, boolean[] b) {
		for (int i = 0; i < 26; i++) {
			if (a[i] == b[i] && a[i] == true)
				return false;
		}
		return true;
	}

	private boolean[] fingerPrint(String str) {
		boolean[] ret = new boolean[26];
		for (int i = 0; i < str.length(); i++) {
			int pos = str.charAt(i) - 'a';
			ret[pos] = true;
		}
		return ret;
	}
}
