package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月12日下午11:00:54
 */

public class FactorialTrailingZeroes {

	// Since 10 = 2*5, and there are always more 2's than 5's, we only need to
	// count the number of 5 factor in n!
	public int trailingZeroes(int n) {
		int s = 0;
		while (n > 4) {
			s = s + (n / 5);
			n = n / 5;
		}
		return s;
	}

}
