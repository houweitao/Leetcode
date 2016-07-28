package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月29日上午1:18:17
 */

public class CombinationSumIII {
	public static void main(String[] args) {
		CombinationSumIII cs = new CombinationSumIII();
		System.out.println(cs.combinationSum3(3, 9));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> ret = new LinkedList<>();
		help(k, n, 1, ret, new LinkedList<Integer>());
		return ret;
	}

	private void help(int k, int n, int pos, List<List<Integer>> ret, LinkedList<Integer> list) {
		if (n < 0)
			return;

		if (list.size() == k) {
			if (n == 0)
				ret.add(new LinkedList<>(list));
			return;
		}

		for (int i = pos; i <= 9; i++) {
			list.add(i);

			help(k, n - i, i + 1, ret, list);

			list.remove(list.size() - 1);
		}

	}

}
