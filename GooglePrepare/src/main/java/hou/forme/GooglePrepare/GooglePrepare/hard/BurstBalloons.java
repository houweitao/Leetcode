package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年12月19日下午1:04:16
 */

public class BurstBalloons {
	public int maxCoins(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		else if (nums.length == 1)
			return nums[0];
		else {
			Map<String, Integer> score = new HashMap<>();

			return help(nums, score);
		}
	}

	private int help(int[] nums, Map<String, Integer> score) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		String key = makeKey(nums);
		if (score.containsKey(key))
			return score.get(key);

		int max = 0;
		for (int i = 0; i < nums.length; i++) {
			int[] next = build(nums, i);
			max = Math.max(max, help(next, score) + count(nums, i));
		}
		score.put(key, max);
		return max;
	}

	private int count(int[] nums, int pos) {
		return get(nums, pos - 1) * get(nums, pos) * get(nums, pos + 1);
	}

	private int get(int[] nums, int i) {
		if (i < 0 || i >= nums.length)
			return 1;
		else
			return nums[i];
	}

	private int[] build(int[] nums, int pos) {
		int[] ret = new int[nums.length - 1];
		int j = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i != pos)
				ret[j++] = nums[i];
		}
		return ret;
	}

	private String makeKey(int[] nums) {
		StringBuilder sb = new StringBuilder();
		for (int i : nums) {
			sb.append(i);
			sb.append(",");
		}
		return sb.toString();
	}
}
