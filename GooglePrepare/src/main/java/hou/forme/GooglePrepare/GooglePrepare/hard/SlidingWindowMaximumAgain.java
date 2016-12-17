package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年12月16日下午2:20:42
 */

public class SlidingWindowMaximumAgain {
	public static void main(String[] args) {
		SlidingWindowMaximumAgain again = new SlidingWindowMaximumAgain();
		int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
		int k = 3;
		again.maxSlidingWindow(nums, k);
	}

	public int[] maxSlidingWindow(int[] nums, int k) {
		int[] ret;
		if (k < 1 || nums == null || nums.length < 1) {
			return new int[0];
		} else if (nums.length < k) {
			return max(nums);
		} else {
			ret = new int[nums.length - k + 1];

			List<Integer> queue = new ArrayList<>();
			for (int i = 0; i < nums.length; i++) {
				while (!queue.isEmpty() && queue.get(0) < i - k + 1) {
					queue.remove(0);
				}

				while (!queue.isEmpty() && nums[queue.get(queue.size() - 1)] < nums[i]) {
					queue.remove(queue.size() - 1);
				}
				queue.add(i);
				if (i >= k - 1) {
					ret[i - k + 1] = nums[queue.get(0)];
				}
			}
			return ret;
		}
	}

	private int[] max(int[] nums) {
		int max = Integer.MIN_VALUE;
		for (int i : nums) {
			max = Math.max(max, i);
		}
		return new int[] { max };
	}
}
