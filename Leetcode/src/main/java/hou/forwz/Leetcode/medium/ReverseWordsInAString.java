package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月19日上午1:54:13
 */

public class ReverseWordsInAString {
	public static void main(String[] args) {
		ReverseWordsInAString rw = new ReverseWordsInAString();
		System.out.println(rw.reverseWords("   a   b"));
	}

	public String reverseWords(String s) {
		s = s.trim();
		s = reverse(s);
		String[] strs = s.split(" ");

		StringBuffer sb = new StringBuffer();
		for (String str : strs) {
			if (str.length() > 0) {
				sb.append(reverse(str));
				sb.append(" ");
			}
		}

		String back = sb.toString();
		if (sb.length() > 0)
			return sb.toString().substring(0, sb.toString().length() - 1);
		else
			return "";

	}

	private String reverse(String s) {
		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--)
			sb.append(s.charAt(i));

		return sb.toString();
	}

}
