package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年8月2日下午10:46:41
 */

public class SubsetsII2 {
	public static void main(String[] args) {
		SubsetsII2 ss = new SubsetsII2();
		int[] nums = { 1, 1, 1 };
		System.out.println(ss.subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length == 0)
			return ret;
		else {
			Arrays.sort(nums);
			help(ret, new LinkedList<Integer>(), nums, 0);
			return ret;
		}
	}

	private void help(List<List<Integer>> ret, List<Integer> tmp, int[] nums, int pos) {
		if (pos <= nums.length) {
			ret.add(new LinkedList<>(tmp));
			// return;
		}
		for (int i = pos; i < nums.length;) {
			tmp.add(nums[i]);
			help(ret, tmp, nums, i + 1);
			tmp.remove(tmp.size() - 1);
			i++;
			while (i < nums.length && nums[i] == nums[i - 1]) {
				i++;
				System.out.println("++");
			}

		}

	}

}
