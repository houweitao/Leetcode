package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月15日上午12:09:14
 */

public class PermutationsII2 {
	boolean[] used;

	public static void main(String[] args) {
		PermutationsII2 per = new PermutationsII2();
		int[] nums = { 1, 1, 2 };
		System.out.println(per.permuteUnique(nums));
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length < 1)
			return ret;

		if (nums.length == 1) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(nums[0]);
			ret.add(tmp);
			return ret;
		}

		used = new boolean[nums.length];

		for (int i = 0; i < nums.length; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				used[i]=true;
				List<List<Integer>> next = help(nums, 1);
				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[0]);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}
				swap(nums, 0, i);

			}
		}
		return ret;

	}

	private List<List<Integer>> help(int[] nums, int pos) {
		List<List<Integer>> ret = new ArrayList<>();
		if (pos >= nums.length)
			return ret;
		else if (pos == nums.length - 1) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(nums[pos]);
			ret.add(tmp);
			return ret;
		} else {

			for (int i = pos; i < nums.length; i++) {
				if (i == pos || nums[i] != nums[i - 1]) {
					swap(nums, pos, i);

					List<List<Integer>> next = help(nums, pos + 1);
					for (int j = 0; j < next.size(); j++) {
						List<Integer> tmp = new ArrayList<>();
						tmp.add(nums[pos]);
						tmp.addAll(next.get(j));
						ret.add(tmp);
					}
					swap(nums, pos, i);

				}
			}

			return ret;
		}

	}

	private void swap(int[] nums, int i, int i2) {
		int tmp = nums[i];
		nums[i] = nums[i2];
		nums[i2] = tmp;
	}
}
