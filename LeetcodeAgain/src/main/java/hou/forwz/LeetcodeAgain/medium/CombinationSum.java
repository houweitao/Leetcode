package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午2:48:02
 */

public class CombinationSum {
	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] nums = { 2, 3, 6, 7 };
		System.out.println(cs.combinationSum(nums, 7));
		System.out.println(cs.combinationSumDP(nums, 7));
	}

	public List<List<Integer>> combinationSumDP(int[] candidates, int target) {
		Arrays.sort(candidates);
		Li[] lis = new Li[target + 1];
		for (int i = 0; i < lis.length; i++)
			lis[i] = new Li();

		for (int i = 1; i < lis.length; i++) {
			for (int num : candidates) {
				if (num == i) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(num);
					lis[i].list.add(tmp);
					break;
				} else if (num < i) {
					if (lis[i - num].list.size() > 0) {
						for (int k = 0; k < lis[i - num].list.size(); k++) {
							if (lis[i - num].list.get(k).get(lis[i - num].list.get(k).size() - 1) <= num) {
								List<Integer> tmp = new ArrayList<>();
								tmp.addAll(lis[i - num].list.get(k));
								tmp.add(num);
								lis[i].list.add(tmp);
							}
						}
					}
				}
			}
		}

		for (int i = 1; i <= target; i++) {
			System.out.println(i + ": " + lis[i].list);
		}

		return lis[target].list;
	}

	class Li {
		List<List<Integer>> list;

		Li() {
			list = new ArrayList<>();
		}
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();

		if (candidates.length == 0)
			return ret;
		Arrays.sort(candidates);
		dfs(candidates, 0, target, tmp, ret);
		return ret;
	}

	private void dfs(int[] nums, int pos, int target, List<Integer> tmp, List<List<Integer>> ret) {
		if (target < 0)
			return;
		if (target == 0) {
			ret.add(new ArrayList<>(tmp));
			return;
		}
		if (pos >= nums.length)
			return;

		for (int i = pos; i < nums.length; i++) {
			if (i != pos && nums[i] == nums[i - 1])
				continue;
			tmp.add(nums[i]);
			dfs(nums, i, target - nums[i], tmp, ret);
			tmp.remove(tmp.size() - 1);
		}
	}

}
