package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月25日下午10:41:26
 */

public class IncreasingTripletSubsequence {

	public boolean increasingTriplet(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MAX_VALUE;

		for (int x : nums) {
			if (x <= min)
				min = x;
			else if (x <= max)
				max = x;
			else
				return true;
		}
		return false;

	}

}
