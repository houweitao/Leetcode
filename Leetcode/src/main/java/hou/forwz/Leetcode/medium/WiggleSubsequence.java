package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月31日上午11:02:01
 */

public class WiggleSubsequence {

	public int wiggleMaxLengthGreedy(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int preDiff = nums[1] - nums[0];
		int count = nums[1] - nums[0] == 0 ? 1 : 2;

		for (int i = 2; i < nums.length; i++) {
			int diff = nums[i] - nums[i - 1];
			if (diff > 0 && preDiff <= 0 || diff < 0 && preDiff >= 0) {//prediff == 0只发生在头部
				count++;
				preDiff = diff;
			}
		}

		return count;

	}

	public int wiggleMaxLength(int[] nums) {
		if (nums.length < 2)
			return nums.length;

		int[] up = new int[nums.length];
		int[] down = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			up[i] = 1;
			down[i] = 1;
		}

		for (int i = 1; i < nums.length; i++) {
			if (up[i - 1] % 2 == 0) {
				if (nums[i] > nums[i - 1])
					up[i] = up[i - 1];
				else
					up[i] = up[i - 1] + 1;
			} else {
				if (nums[i] > nums[i - 1])
					up[i] = up[i - 1] + 1;
				else
					up[i] = up[i - 1];
			}

			if (down[i - 1] % 2 == 1) {
				if (nums[i] > nums[i - 1])
					down[i] = down[i - 1];
				else
					down[i] = down[i - 1] + 1;
			} else {
				if (nums[i] > nums[i - 1])
					down[i] = down[i - 1] + 1;
				else
					down[i] = down[i - 1];
			}
		}

		return Math.max(up[nums.length - 1], down[nums.length - 1]);
	}

}
