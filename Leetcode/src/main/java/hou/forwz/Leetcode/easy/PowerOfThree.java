package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月24日下午9:24:28
 */

public class PowerOfThree {

	public boolean isPowerOfThree(int n) {
		return n > 0 && (1162261467 % n == 0);
	}

}
