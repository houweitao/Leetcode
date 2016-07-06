package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月6日下午8:40:54
 */

public class ReverseInteger {

	public int reverse(int x) {
		long rev = 0;
		while (x != 0) {
			rev = rev * 10 + x % 10;
			x = x / 10;
			if (rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
				return 0;
		}
		return (int) rev;
	}

}
