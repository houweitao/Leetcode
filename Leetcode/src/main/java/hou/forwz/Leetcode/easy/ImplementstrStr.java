package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月8日下午9:50:45
 */

public class ImplementstrStr {

	public int strStr(String haystack, String needle) {
		if (needle.length() < 1)
			return 0;
		if (haystack.length() < 1 || needle.length() > haystack.length())
			return -1;

		for (int i = 0; i < haystack.length(); i++) {
			if (haystack.charAt(i) == needle.charAt(0)) {
				for (int j = i + 1; j < needle.length() + i; j++) {
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
