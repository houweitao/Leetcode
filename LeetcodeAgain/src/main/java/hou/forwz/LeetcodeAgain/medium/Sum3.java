package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日上午11:17:24
 */

public class Sum3 {
	public static void main(String[] args) {
		Sum3 sum = new Sum3();
		int[] nums = { 0, 0, 0, 0 };
		System.out.println(sum.threeSumMe(nums));
	}

	public List<List<Integer>> threeSumMe(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // Skip same results

			int left = i + 1, right = nums.length - 1;
			while (left < right) {
				if (nums[left] + nums[right] + nums[i] == 0) {
					ret.add(Arrays.asList(nums[i], nums[left], nums[right]));
					while (nums[right] == nums[right - 1]) {
						right--;
					}
					while (nums[left] == nums[left + 1]) {
						left++;
					}
					right--;
					left++;

				} else if (nums[left] + nums[right] + nums[i] > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return ret;
	}

	public List<List<Integer>> threeSumBetter(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;
		Arrays.sort(nums);

		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue; // Skip same results
			int target = 0 - nums[i];
			int j = i + 1, k = len - 1;
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					while (j < k && nums[j] == nums[j + 1])
						j++; // Skip same results
					while (j < k && nums[k] == nums[k - 1])
						k--; // Skip same results
					j++;
					k--;
				} else if (nums[j] + nums[k] < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return result;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			if (i != 0 && nums[i] == nums[i - 1])
				continue;

			int left = i + 1, right = nums.length - 1;

			while (left < right) {
				// System.out.println(nums[left] + "," + nums[right]);
				if (nums[left] + nums[right] + nums[i] > 0) {
					if (right != nums.length - 1)
						while (right > left && (right == nums.length - 1 || nums[right] == nums[right + 1]))
							right--;
					right--;
				} else if (nums[left] + nums[right] + nums[i] < 0) {
					if (left != i + 1)
						while (right > left && (left == i + 1 || nums[left] == nums[left - 1]))
							left++;
					left++;
				} else {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[i]);
					tmp.add(nums[left]);
					tmp.add(nums[right]);
					ret.add(tmp);
					int now = nums[left];
					while (true) {
						if (left < right && nums[left] == now)
							left++;
						else
							break;
					}
				}
			}
		}
		return ret;
	}

}
