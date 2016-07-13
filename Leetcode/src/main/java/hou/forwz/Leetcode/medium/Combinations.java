package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月14日上午1:24:21
 */

public class Combinations {
	public static void main(String[] args) {
		Combinations c = new Combinations();
		System.out.println(c.combine(6, 3));
	}

	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> ret = new ArrayList<>();
		if(n<k)
			return ret;
		return help(n, 1, k);
	}

	private List<List<Integer>> help(int n, int begin, int k) {
		List<List<Integer>> ret = new ArrayList<>();

		if (k == 1) {
			for (int i = begin; i <= n; i++) {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				ret.add(tmp);
			}
			return ret;

		} else if (begin + k - 1 == n) {
			List<Integer> tmp = new ArrayList<>();
			for (int i = begin; i <= n; i++)
				tmp.add(i);
			ret.add(tmp);
			return ret;
		} else {
			for (int i = begin; i <= n - k + 1; i++) {
				List<List<Integer>> next = help(n, i + 1, k - 1);
				for (int j = 0; j < next.size(); j++) {
					List<Integer> tmp = new ArrayList<>();
					tmp.add(i);
					tmp.addAll(next.get(j));
					ret.add(tmp);
				}
			}

			return ret;
		}
	}

}
