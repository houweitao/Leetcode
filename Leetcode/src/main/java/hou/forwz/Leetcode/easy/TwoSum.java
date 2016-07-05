package hou.forwz.Leetcode.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年7月5日下午10:06:33
 */

public class TwoSum {

	public int[] twoSum(int[] nums, int target) {
		if (nums == null || nums.length < 1)
			return null;

		Map<Integer, Integer> record = new HashMap<>();
		int[] ret = new int[2];

		for (int i = 0; i < nums.length; i++) {
			if (record.containsKey(target - nums[i])) {
				ret[0] = record.get(target - nums[i]);
				ret[1] = i;

				return ret;
			} else {
				record.put(nums[i], i);
			}
		}

		return ret;
	}

}
