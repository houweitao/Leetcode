package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月6日下午8:52:53
 */

public class String2Integers {

	public int myAtoi(String str) {
		str = str.trim();

		if (str == null || str.length() < 1)
			return 0;

		if (str.charAt(0) == '-') {
			int num = myAtoi(str.substring(1));
			if (num == 0)
				return num;
			else
				return num * -1;
		}
		if (str.charAt(0) == '+') {
			int num = myAtoi(str.substring(1));
			return num;
		}

		long ret = 0;

		for (int i = 0; i < str.length(); i++) {
			if (is(str.charAt(i)))
				ret = ret * 10 + Integer.valueOf(str.charAt(i) + "");
			else
				return 0;
			if (ret > Integer.MAX_VALUE)
				return 0;
		}
		return (int) ret;

	}

	private boolean is(char c) {
		if ((c - '0') >= 0 && c - '9' <= 0)
			return true;
		else
			return false;
	}

}
