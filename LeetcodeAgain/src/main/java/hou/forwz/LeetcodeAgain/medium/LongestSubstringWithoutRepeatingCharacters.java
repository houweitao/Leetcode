package hou.forwz.LeetcodeAgain.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年9月14日下午8:04:45
 */

public class LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {
		LongestSubstringWithoutRepeatingCharacters ls = new LongestSubstringWithoutRepeatingCharacters();
		System.out.println(ls.lengthOfLongestSubstring("abba"));
	}

	public int lengthOfLongestSubstring(String s) {
		if (s.length() < 2)
			return s.length();
		Map<Character, Integer> map = new HashMap<>();
		int max = 1;
		for (int i = 0, j = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)) {
				j = Math.max(j, map.get(c) + 1);
			}

			map.put(c, i);
			max = Math.max(max, i - j + 1);
		}
		return max;
	}

}
