package hou.forwz.Leetcode.medium;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月24日下午10:43:04
 */

public class PermutationsII3 {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		List<Integer> tmp = new LinkedList<>();
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		dfs(nums, used, ret, tmp);

		return ret;

	}

	private void dfs(int[] nums, boolean[] used, List<List<Integer>> ret, List<Integer> tmp) {
		if (tmp.size() == nums.length)
			ret.add(new LinkedList<>(tmp));

		for (int i = 0; i < nums.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && nums[i - 1] == nums[i] && !used[i - 1])
				continue;

			used[i] = true;
			tmp.add(nums[i]);
			dfs(nums, used, ret, tmp);
			tmp.remove(tmp.size() - 1);
			used[i] = false;
		}

	}
}
