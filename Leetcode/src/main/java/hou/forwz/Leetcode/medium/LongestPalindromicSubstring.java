package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月6日上午12:02:33
 */

public class LongestPalindromicSubstring {

	public String longestPalindrome(String s) {

		if (s.length() == 1)
			return s;

		int len = s.length();
		int[][] record = new int[len][len];

		int max = 0;
		String ret = "";

		for (int i = 0; i < len; i++) {
			record[i][i] = 1;
			if (1 > max)
				ret = s.charAt(i) + "";
		}

		for (int i = 0; i < len - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1)) {
				record[i][i + 1] = 1;
				if (2 > max) {
					max = 2;
					ret = s.substring(i, i + 2);
				}
			} else
				record[i][i + 1] = 0;
		}

		for (int j = 3; j <= len; j++) {
			for (int i = 0; i < len - j + 1; i++) {
				if (i + j <= len) {
					if (s.charAt(i) == s.charAt(i + j - 1) && record[i + 1][i + j - 2] == 1) {
						record[i][i + j - 1] = 1;
						if (j > max) {
							max = j;
							ret = s.substring(i, i + j);
						}
					}
				}
			}
		}
		System.out.println(max);
		return ret;
	}

}
