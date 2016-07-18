package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月18日下午11:34:28
 */

public class MissingNumber {

	public int missingNumber(int[] nums) {
		if (nums.length < 1)
			return 1;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = sum + nums[i];
		}

		return (nums.length + 1 + 1) * (nums.length + 1) / 2 - sum;
	}

}
