package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月31日上午1:46:29
 */

public class ImplementStrStr2 {

	public int strStr(String haystack, String needle) {

		if (needle.length() < 1)
			return 0;
		if (haystack.length() < 1 || needle.length() > haystack.length())
			return -1;
		if (haystack.equals(needle))
			return 0;

		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				for (int j = i; j < needle.length() + i && j < haystack.length(); j++) {
					if (haystack.charAt(j) != needle.charAt(j - i)) {
						break;
					}
					if (j == needle.length() - 1 + i)
						return i;
				}
			}

		}
		return -1;

	}

}
