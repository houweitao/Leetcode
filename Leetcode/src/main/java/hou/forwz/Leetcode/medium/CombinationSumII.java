package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月8日上午12:17:07
 */

public class CombinationSumII {

	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		int[] candidates = { 10, 1, 2, 2, 7, 6, 1, 5 };
		System.out.println(cs.combinationSum(candidates, 8));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);

		int[] next = generateNext(candidates);
		return help(candidates, target, 0, candidates.length - 1, next);
	}

	private int[] generateNext(int[] candidates) {
		int[] next = new int[candidates.length];
		for (int i = 0; i < candidates.length; i++) {
			if (i == 0)
				next[i] = 1;
			else {
				int count = 0;
				while (candidates[i] == candidates[i - 1]) {
					i++;
					count++;
				}
				next[i] = count;
			}

		}

		return next;
	}

	private List<List<Integer>> help(int[] candidates, int target, int begin, int end, int[] next) {
		System.out.println(target + "," + begin + "," + end);

		List<List<Integer>> ret = new ArrayList<>();
		if (candidates[begin] > target || end < begin)
			return ret;

		for (int i = begin; i <= end; i = i + next[i]) {

			// if (i == 0 || candidates[i] != candidates[i - 1])
			if (candidates[i] == target) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(target);
				ret.add(tmp);
			} else if (candidates[i] < target) {
				List<List<Integer>> nextList = help(candidates, target - candidates[i], i + 1, end, next);
				for (int j = 0; j < nextList.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(candidates[i]);
					tmp.addAll(nextList.get(j));
					ret.add(tmp);
				}
			} else
				break;
		}

		return ret;
	}

}
