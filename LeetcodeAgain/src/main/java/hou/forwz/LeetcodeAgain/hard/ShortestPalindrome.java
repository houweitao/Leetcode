package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月26日下午6:17:36
 */

public class ShortestPalindrome {

	public static void main(String[] args) {
		ShortestPalindrome sp = new ShortestPalindrome();
		String s = "ab";

		System.out.println(sp.shortestPalindrome(s));
	}

	public String shortestPalindrome(String s) {
		String str = "";
		if (s.equals(str))
			return s;
		for (int i = 0; i < s.length() / 2+1 ; i++) {
			String left = expend(s, i);
			if (left.length() != 0) {
				if (left.length() > str.length())
					str = left;
			}

		}

		String append = make(s, str);

		System.out.println(str);
		System.out.println(s);
		System.out.println(append);

		return append + s;
	}

	private String make(String s, String str) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= str.length(); i--) {
			sb.append(s.charAt(i));
		}

		return sb.toString();
	}

	private String expend(String s, int pos) {
		String ret = "";
		int left = pos, right = pos;
		while (left >= 0&&right<s.length()) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				
			} else
				break;
		}

		if (left == -1) {
			return s.substring(0, 2 * pos + 1);
		}

		left = pos - 1;
		right = pos;
		while (left >= 0) {
			if (s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
			} else
				break;
		}

		if (left == -1) {
			return s.substring(0, 2 * pos);
		}

		return ret;
	}

}
