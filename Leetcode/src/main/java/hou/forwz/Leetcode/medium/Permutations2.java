package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月24日下午10:52:44
 */

public class Permutations2 {
	public static void main(String[] args) {
		Permutations2 p = new Permutations2();
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(p.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> ret = new LinkedList<>();
		List<Integer> tmp = new LinkedList<>();

		dfs(nums, 0, ret, tmp);

		return ret;
	}

	private void dfs(int[] nums, int pos, List<List<Integer>> ret, List<Integer> tmp) {
		if (pos == nums.length)
			ret.add(new LinkedList<>(tmp));
		else {
			for (int i = pos; i < nums.length; i++) {
				swap(nums, pos, i);
				tmp.add(nums[pos]);
				dfs(nums, pos + 1, ret, tmp);
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
