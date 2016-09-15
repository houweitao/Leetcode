package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月16日上午2:03:38
 */

public class SubsetsII2 {
	public static void main(String[] args) {
		SubsetsII2 sb = new SubsetsII2();
		int[] nums = { 1, 1, 2 };
		System.out.println(sb.subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length == 0)
			return ret;
		Arrays.sort(nums);
		List<Integer> tmp = new ArrayList<>();
		dfs(nums, 0, tmp, ret);
		return ret;
	}

	private void dfs(int[] nums, int pos, List<Integer> tmp, List<List<Integer>> ret) {
		ret.add(new ArrayList<>(tmp));

		if (pos == nums.length)
			return;

		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1]) {
				continue;
			} else {
				tmp.add(nums[i]);
				dfs(nums, i + 1, tmp, ret);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
