package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月6日上午1:14:33
 */

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;

		int len = s.length();
		String max = "";

		for (int i = len / 2 + 1; i >= 0; i--) {
			String first = expend(s, i, i);
			String second = expend(s, i, i + 1);

			if (first.length() > max.length())
				max = first;
			if (second.length() > max.length())
				max = second;

			if (first.length() > 0 || second.length() > 0)
				break;
		}

		String help = "";
		for (int i = max.length(); i < len; i++) {
			help = s.charAt(i) + help;
		}

		return help + s;
	}

	private String expend(String s, int begin, int end) {
		while (begin >= 0 && end < s.length() && s.charAt(begin) == s.charAt(end)) {
			begin--;
			end++;
		}
		if (begin == -1)
			return s.substring(begin + 1, end);
		else
			return "";
	}
}
