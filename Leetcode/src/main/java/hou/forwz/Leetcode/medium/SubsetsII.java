package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月21日上午1:12:39
 */

public class SubsetsII {
	public static void main(String[] args) {
		SubsetsII ss = new SubsetsII();
		int[] nums = { 1, 2, 2 };
		System.out.println(ss.subsetsWithDup(nums));
	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> each = new ArrayList<>();
		helper(res, each, 0, nums);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
		if (pos <= n.length) {
			res.add(each);
		}
		int i = pos;
		while (i < n.length) {
			each.add(n[i]);
			helper(res, new ArrayList<>(each), i + 1, n);
			each.remove(each.size() - 1);
			i++;
			while (i < n.length && n[i] == n[i - 1]) {
				i++;
			}
		}
		return;
	}
}
