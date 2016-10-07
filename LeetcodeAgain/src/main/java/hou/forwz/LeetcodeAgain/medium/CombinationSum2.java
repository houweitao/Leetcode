package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年10月7日下午7:03:20
 */

public class CombinationSum2 {
	public static void main(String[] args) {
		CombinationSum2 cs = new CombinationSum2();
		int[] candidates = { 2, 3, 6, 7 };
		System.out.println(cs.combinationSum(candidates, 7));
	}

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> ret = new ArrayList<>();
		if (candidates == null || candidates.length == 0)
			return ret;
		List<Integer> tmp = new ArrayList<>();
		for (int i = 0; i < candidates.length; i++)
			help(candidates, i, target, tmp, ret);
		return ret;
	}

	private void help(int[] candidates, int pos, int target, List<Integer> tmp, List<List<Integer>> ret) {
		if (pos == candidates.length) {
			return;
		} else if (candidates[pos] > target)
			return;
		else if (candidates[pos] == target) {
			tmp.add(candidates[pos]);
			ret.add(new ArrayList<>(tmp));
			tmp.remove(tmp.size() - 1);
		} else {
			tmp.add(candidates[pos]);
			for (int i = pos; i < candidates.length; i++) {
				help(candidates, i, target - candidates[pos], tmp, ret);
			}
			tmp.remove(tmp.size() - 1);
		}
	}

}
