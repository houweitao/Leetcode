package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月5日下午4:51:31
 */

public class CombinationSumII {
	public static void main(String[] args) {
		CombinationSumII com = new CombinationSumII();
		int[] cand = { 10, 1, 2, 7, 6, 1, 5 };
		System.out.println(com.combinationSum2(cand, 8));
	}

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();

		Arrays.sort(candidates);

		dfs(candidates, 0, target, tmp, ret);

		return ret;
	}

	private void dfs(int[] candidates, int pos, int target, List<Integer> tmp, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(tmp));
			return;
		}

		if (pos >= candidates.length)
			return;
		if (target < candidates[pos])
			return;
		else {
			for (int i = pos; i < candidates.length; i++) {
				if (i != pos && candidates[i] == candidates[i - 1]) {
					continue;
				}

				tmp.add(candidates[i]);
				dfs(candidates, i + 1, target - candidates[i], tmp, ret);
				tmp.remove(tmp.size() - 1);
			}
		}

	}

}
