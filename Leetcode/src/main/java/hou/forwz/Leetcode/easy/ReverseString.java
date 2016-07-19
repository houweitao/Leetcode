package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月20日上午12:31:14
 */

public class ReverseString {

	public String reverseString(String s) {
		if (s.length() <= 1)
			return s;

		StringBuffer sb = new StringBuffer();
		for (int i = s.length() - 1; i >= 0; i--)
			sb.append(s.charAt(i));

		return sb.toString();
	}

}
