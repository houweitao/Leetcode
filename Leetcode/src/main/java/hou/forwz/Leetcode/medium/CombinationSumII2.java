package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月22日下午11:35:24
 */

public class CombinationSumII2 {
	List<List<Integer>> ret = new LinkedList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		if (candidates.length == 0)
			return ret;

		Arrays.sort(candidates);
		List<Integer> tmp = new ArrayList<>();
		help(candidates, target, 0, tmp);
		return ret;
	}

	private void help(int[] candidates, int target, int pos, List<Integer> tmp) {
		if (target == 0)
			ret.add(new LinkedList<>(tmp));
		else if (pos > candidates.length || target < 0)
			return;
		else {
			for (int i = pos; i < candidates.length; i++) {
				if (i > pos && candidates[i] == candidates[i - 1])
					continue;

				tmp.add(candidates[i]);

				help(candidates, target - candidates[i], i + 1, tmp);

				tmp.remove(tmp.size() - 1);
			}
		}
	}

}
