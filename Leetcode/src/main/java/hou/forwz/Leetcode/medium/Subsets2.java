package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月15日下午11:44:39
 */

public class Subsets2 {
	public static void main(String[] args) {
		Subsets2 ss = new Subsets2();
		int[] nums = { 1, 2, 3, 4, 5 };
		System.out.println(ss.subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();

		help(nums, 0, ret, tmp);
		return ret;
	}

	private void help(int[] nums, int pos, List<List<Integer>> ret, List<Integer> tmp) {
		ret.add(new ArrayList<Integer>(tmp));
		for (int i = pos; i < nums.length; i++) {
			tmp.add(nums[i]);
			help(nums, i + 1, ret, tmp);
			tmp.remove(tmp.size() - 1);
		}
	}

}
