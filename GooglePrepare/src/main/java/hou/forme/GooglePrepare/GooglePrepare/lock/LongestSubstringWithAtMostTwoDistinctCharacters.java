package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月11日上午10:31:22
 * @end 2016年12月11日10:46:03
 * @url http://www.programcreek.com/2013/02/longest-substring-which-contains-2-unique-characters/
 * @url http://www.cnblogs.com/grandyang/p/5185561.html
 */

public class LongestSubstringWithAtMostTwoDistinctCharacters {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
		if (s == null)
			return 0;
		if (s.length() < 3)
			return s.length();
		Map<Character, Integer> map = new HashMap<>();
		char[] ch = s.toCharArray();
		int left = 0;
		int max = 0;

		for (int i = 0; i < ch.length; i++) {
			if (!map.containsKey(ch[i])) {
				map.put(ch[i], 0);
			}

			map.put(ch[i], map.get(ch[i]) + 1);

			while (map.size() > 2 && left < i) {
				max = Math.max(max, i - 1 - left + 1);
				if (map.get(ch[left]) == 1)
					map.remove(ch[left]);
				else
					map.put(ch[left], map.get(ch[left]) - 1);
				left++;
			}

		}
		max = Math.max(max, s.length() - left);

		return max;
	}
}
