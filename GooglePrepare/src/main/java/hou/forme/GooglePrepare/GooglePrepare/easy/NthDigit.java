package hou.forme.GooglePrepare.GooglePrepare.easy;

/**
 * @author houweitao
 * @date 2016年12月9日下午2:30:56
 */

public class NthDigit {
	public int findNthDigit(int n) {
		int len = 1;
		long count = 9;
		int start = 1;

		while (n > len * count) {
			n -= len * count;
			len += 1;
			count *= 10;
			start *= 10;
		}

		start += (n - 1) / len;
		String s = Integer.toString(start);
		return Character.getNumericValue(s.charAt((n - 1) % len));
	}
}
