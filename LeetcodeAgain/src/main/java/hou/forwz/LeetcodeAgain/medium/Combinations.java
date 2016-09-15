package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午3:14:13
 */

public class Combinations {
	public static void main(String[] args) {
		Combinations cb = new Combinations();
		System.out.println(cb.combine(4, 2));
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		List<Integer> tmp = new ArrayList<>();
		if (n == 0)
			return ret;
		dfs(1, n, k, tmp, ret);
		return ret;
	}

	private void dfs(int begin, int end, int k, List<Integer> tmp, List<List<Integer>> ret) {
		if (k == 0) {
			ret.add(new ArrayList<>(tmp));
		} else {
			for (int i = begin; i + k <= end + 1; i++) {
				tmp.add(i);
				dfs(i + 1, end, k - 1, tmp, ret);
				tmp.remove(tmp.size() - 1);
			}
		}
	}
}
