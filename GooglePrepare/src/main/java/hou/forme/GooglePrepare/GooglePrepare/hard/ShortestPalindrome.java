package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月5日下午10:05:48
 * @end 2016年12月05日22:21:55
 * @tips 注意从中间往前
 */

public class ShortestPalindrome {
	public String shortestPalindrome(String s) {
		if (s == null || s.length() < 2)
			return s;

		String ret = s + s;
		for (int i = (s.length() - 1) / 2; i >= 0; i--) {
			if (canReachLeftEnd(s, i, i)) {
				String maybe = build(s, i + i + 1);
				if (maybe.length() < ret.length()) {
					ret = maybe;
					break;
				}

			}
			if (canReachLeftEnd(s, i - 1, i)) {
				String maybe = build(s, i - 1 + i + 1);
				if (maybe.length() < ret.length()) {
					ret = maybe;
					break;
				}
			}
		}
		return ret;
	}

	private String build(String s, int i) {
		StringBuilder sb = new StringBuilder();
		sb.append(new StringBuffer(s.substring(i)).reverse());
		sb.append(s);
		return sb.toString();
	}

	private boolean canReachLeftEnd(String s, int left, int right) {
		if (left < 0)
			return false;

		while (left >= 0) {
			if (s.charAt(left--) == s.charAt(right++)) {

			} else
				return false;
		}
		return true;
	}
}
