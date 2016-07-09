package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月10日上午1:25:43
 */

public class Permutations {

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = { 1, 1, 3 };
		System.out.println(p.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		return help(nums, 0);
	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

	private List<List<Integer>> help(int[] nums, int begin) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length == begin + 1) {
			List<Integer> tmp = new ArrayList<>();
			tmp.add(nums[begin]);
			ret.add(tmp);
			return ret;
		} else {
			for (int i = begin; i < nums.length; i++) {
				swap(nums, begin, i);

				List<List<Integer>> next = help(nums, begin + 1);
				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(nums[begin]);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}

				swap(nums, begin, i);
			}

			return ret;
		}

	}
}
