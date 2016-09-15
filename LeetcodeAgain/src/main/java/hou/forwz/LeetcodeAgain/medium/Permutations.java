package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午3:21:02
 */

public class Permutations {
	public static void main(String[] args) {
		Permutations per = new Permutations();
		int[] nums = { 1, 2, 3 };
		System.out.println(per.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		if (nums.length < 1)
			return ret;
		Arrays.sort(nums);
		dfs(nums, 0, tmp, ret);
		return ret;
	}

	private void dfs(int[] nums, int pos, List<Integer> tmp, List<List<Integer>> ret) {
		if (pos == nums.length) {
			ret.add(new ArrayList<>(tmp));
		} else {
			for (int i = pos; i < nums.length; i++) {
//				if (i != pos && nums[i] == nums[i - 1])
//					continue;
				swap(nums, pos, i);
				tmp.add(nums[pos]);
				dfs(nums, pos + 1, tmp, ret);
				tmp.remove(tmp.size() - 1);
				swap(nums, pos, i);
			}
		}

	}

	private void swap(int[] nums, int i, int j) {
		int tmp = nums[i];
		nums[i] = nums[j];
		nums[j] = tmp;
	}

}
