package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月13日上午12:03:04
 */

public class RemoveDuplicateLetters2 {

	public String removeDuplicateLetters(String s) {
		if (s.length() < 2)
			return s;
		int[] exist = new int[128];
		int pos = 0;
		for (int i = 0; i < s.length(); i++) {
			exist[s.charAt(i)]++;
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c < s.charAt(pos))
				pos = i;
			exist[c]--;
			if (exist[c] == 0)
				break;
		}

		return s.length() == 0 ? ""
				: s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replaceAll("" + s.charAt(pos), ""));
	}

}
