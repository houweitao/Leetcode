package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月15日上午11:05:49
 */

public class ReverseInteger {

	public int reverse(int x) {
		if (x == Integer.MIN_VALUE)
			return 0;
		else if (x < 0)
			return -reverse(-x);
		else {
			long ret = 0;
			while (x > 0) {
				ret = 10 * ret + x % 10;
				x = x / 10;
			}
			if (ret > Integer.MAX_VALUE)
				return 0;
			else
				return (int) ret;
		}
	}

}
