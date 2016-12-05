package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:10:22
 */

public class FindPeakElement {
	public int findPeakElementMe(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > get(nums, i - 1) && nums[i] > get(nums, i + 1)) {
				return i;
			}
		}
		return -1;
	}

	private long get(int[] nums, int i) {
		if (i < 0 || i >= nums.length)
			return Long.MIN_VALUE;
		else
			return nums[i];
	}

	// 确实。。 中间的比较定了基调 2016年12月05日21:17:44
	public int findPeakElement(int[] num) {
		return helper(num, 0, num.length - 1);
	}

	public int helper(int[] num, int start, int end) {
		if (start == end) {
			return start;
		} else if (start + 1 == end) {
			if (num[start] > num[end])
				return start;
			return end;
		} else {

			int m = (start + end) / 2;

			if (num[m] > num[m - 1] && num[m] > num[m + 1]) {

				return m;

			} else if (num[m - 1] > num[m] && num[m] > num[m + 1]) {

				return helper(num, start, m - 1);

			} else {

				return helper(num, m + 1, end);

			}

		}
	}
}
