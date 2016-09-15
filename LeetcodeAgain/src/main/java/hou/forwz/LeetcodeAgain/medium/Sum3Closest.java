package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午12:04:13
 */

public class Sum3Closest {

	public int threeSumClosest(int[] nums, int target) {

		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int ret = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // Skip same results

			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				int sum = nums[left] + nums[right] + nums[i];
				System.out.println(sum);
				if (sum == target) {
					return sum;
				} else if (sum > target) {
					if (sum - target < min)
						ret = sum;
					while (right > left && nums[right] == nums[right - 1]) {
						right--;
					}

					right--;
				} else {
					if (target - sum < min)
						ret = sum;
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					left++;
				}
			}
		}
		return ret;

	}

}
