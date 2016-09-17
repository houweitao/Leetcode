package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月17日下午4:38:32
 */

public class FindTheDuplicateNumber {

	public int findDuplicate(int[] nums) {
		int left = 1, right = nums.length - 1;

		while (left <= right) {
			int mid = left + (right - left) / 2;

			int count = 0;
			for (int i : nums) {
				if (i <= mid)
					count++;
			}

			int normal = mid;
			if (count <= normal) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}

		}

		return left;
	}

}
