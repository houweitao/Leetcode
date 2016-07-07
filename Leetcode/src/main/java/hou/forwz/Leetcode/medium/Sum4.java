package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月8日上午1:18:15
 */

public class Sum4 {

	public static void main(String[] args) {
		Sum4 s4 = new Sum4();
		int[] nums = { 0, 0, 0, 0 };
		System.out.println(s4.fourSum(nums, 0));
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		Arrays.sort(nums);
		int len = nums.length;
		for (int i = 0; i < len - 3; i++) {
			for (int j = i + 1; j < len - 2; j++) {
				int tar = target - nums[i] - nums[j];
				int left = j + 1, right = len - 1;
				while (left < right) {
					int sum = nums[left] + nums[right];
					if (sum < tar) {
						left++;
					} else if (sum > tar) {
						right--;
					} else {

						// System.out.println("!!");

						List<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);

						ret.add(tmp);

						while ((left + 1 < right) && nums[left + 1] == nums[left])
							left++;
						while ((right - 1 > left) && nums[right - 1] == nums[right])
							right--;
						left++;
						right--;
					}
				}

				while (true) {
					if ((j + 1 < len) && nums[j + 1] == nums[j])
						j++;
					else
						break;
				}

			}

			while (true) {
				if ((i + 1 < len) && nums[i + 1] == nums[i])
					i++;
				else
					break;
			}
		}
		return ret;
	}

}
