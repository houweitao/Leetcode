package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午8:08:34
 */

public class CombinationSumIII {
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		System.out.println(cs.combinationSum3(3, 9));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();

		dfs(1, k, n, tmp, ret);
		return ret;
	}

	private void dfs(int pos, int k, int target, List<Integer> tmp, List<List<Integer>> ret) {
		if (k == 0) {
			if (target == 0) {
				ret.add(new ArrayList<>(tmp));
			}
		} else if (target < 0 || pos > 9)
			return;
		else {
			for (int i = pos; i <= 9; i++) {
				tmp.add(i);
				dfs(i+1, k - 1, target - i, tmp, ret);
				tmp.remove(tmp.size() - 1);
			}
		}

	}

}
