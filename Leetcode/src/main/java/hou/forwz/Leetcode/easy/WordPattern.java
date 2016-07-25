package hou.forwz.Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月25日下午10:54:19
 */

public class WordPattern {

	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (strs.length != pattern.length())
			return false;

		Map<Character, String> cs = new HashMap<>();
		Map<String, Character> sc = new HashMap<>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			String s = strs[i];

			if (!cs.containsKey(c) && !sc.containsKey(s)) {
				cs.put(c, s);
				sc.put(s, c);
			} else if (cs.containsKey(c) && sc.containsKey(s)) {
				if (!cs.get(c).equals(s) || sc.get(s) != c)
					return false;
			} else
				return false;

		}
		return true;

	}

}
