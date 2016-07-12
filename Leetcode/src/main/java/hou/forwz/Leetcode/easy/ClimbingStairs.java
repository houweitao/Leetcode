package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月13日上午12:04:13
 */

public class ClimbingStairs {

	public int climbStairs(int n) {
		if (n < 1)
			return 0;
		else if (n < 3)
			return n;
		int[] step = new int[n + 1];
		step[1] = 1;
		step[2] = 2;

		for (int i = 3; i <= n; i++)
			step[i] = step[i - 1] + step[i - 2];

		return step[n];
	}

}
