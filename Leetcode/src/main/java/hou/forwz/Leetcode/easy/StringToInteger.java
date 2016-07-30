package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月31日上午1:48:28
 */

public class StringToInteger {
	public static void main(String[] args) {
		StringToInteger si = new StringToInteger();
		System.out.println(si.myAtoi("-156"));
	}

	public int myAtoi(String str) {
		str = str.trim();

		if (str == null || str.length() < 1)
			return 0;
		if (str.length() > 1)
			if (str.charAt(1) == '-' || str.charAt(1) == '+') {
				return 0;
			}

		boolean neg = false;
		boolean jump = false;
		if (str.charAt(0) == '-') {
			// System.out.println("??");
			neg = true;
			jump = true;
		} else if (str.charAt(0) == '+') {
			jump = true;
		}

		long ret = 0;

		for (int i = 0; i < str.length(); i++) {
			if (jump && i == 0) {
				continue;
			}
			if (is(str.charAt(i))) {
				ret = ret * 10 + Integer.valueOf((str.charAt(i) - '0'));
//				System.out.println(ret);
				long tmp=(long)Integer.MAX_VALUE + 1;
				if (ret > tmp) {
//					System.out.println("break");
					break;
				}
			} else {
				break;
			}
		}

		if (neg)
			ret = ret * -1;

		// System.out.println("..." + ret);

		if (ret > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		if (ret < Integer.MIN_VALUE)
			return Integer.MIN_VALUE;
		return (int) ret;

	}

	private boolean is(char c) {
		if ((c - '0') >= 0 && c - '9' <= 0)
			return true;
		else
			return false;
	}

}
