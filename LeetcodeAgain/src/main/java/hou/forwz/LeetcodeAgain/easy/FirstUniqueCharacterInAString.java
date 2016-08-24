package hou.forwz.LeetcodeAgain.easy;

import java.util.*;

/**
 * @author houweitao
 * @date 2016年8月24日下午9:32:36
 */

public class FirstUniqueCharacterInAString {

	public int firstUniqChar(String s) {
		if (s.length() < 1)
			return -1;
		else if (s.length() == 1)
			return 0;

		char[] ch = new char[26];
		boolean[] have = new boolean[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			ch[c - 'a']++;
			have[c - 'a'] = true;
		}

		for (int i = 0; i < s.length(); i++) {
			int pos = s.charAt(i) - 'a';

			if (have[pos] && ch[pos] == 1)
				return i;
		}
		return -1;
	}

}
