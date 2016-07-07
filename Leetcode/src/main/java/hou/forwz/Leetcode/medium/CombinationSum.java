package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月7日下午11:58:18
 */

public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		int[] candidates = { 2, 3, 5, 7 };
		System.out.println(cs.combinationSum(candidates, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		return help(candidates, target, 0, candidates.length - 1);
	}

	private List<List<Integer>> help(int[] candidates, int target, int begin, int end) {

		List<List<Integer>> ret = new ArrayList<>();
		if (candidates[begin] > target)
			return ret;

		for (int i = begin; i <= end; i++) {
			if (candidates[i] == target) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(target);
				ret.add(tmp);
			} else if (candidates[i] < target) {
				List<List<Integer>> next = help(candidates, target - candidates[i], i, end);
				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(candidates[i]);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}
			} else
				break;
		}

		return ret;
	}

}
