package hou.forwz.Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月23日上午1:38:52
 */

public class IsomorphicStrings {

	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> sec = new HashMap<>();
		Map<Character, Character> fir = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i), b = t.charAt(i);
			if (fir.containsKey(a) && sec.containsKey(b)) {
				if (fir.get(a) != b || sec.get(b) != a)
					return false;
			} else if (fir.containsKey(a)) {
				return false;
			} else if (sec.containsKey(b)) {
				return false;
			} else {
				fir.put(a, b);
				sec.put(b, a);
			}
		}
		return true;

	}

}
