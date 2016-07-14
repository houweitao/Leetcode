package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月14日下午10:32:15
 */

public class PascalsTriangleII {

	public List<Integer> getRow(int rowIndex) {
		List<List<Integer>> ret = generate(rowIndex + 1);
		return ret.get(ret.size() - 1);
	}

	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> ret = new ArrayList<>();
		if (numRows == 0)
			return ret;

		List<Integer> seed = new ArrayList<>();
		seed.add(1);
		ret.add(seed);
		for (int i = 1; i < numRows; i++) {
			List<Integer> tmp = ret.get(ret.size() - 1);
			List<Integer> cur = new ArrayList<>();
			cur.add(1);
			for (int j = 1; j < i; j++) {
				cur.add(tmp.get(j - 1) + tmp.get(j));
			}
			cur.add(1);

			ret.add(cur);
		}
		return ret;
	}
}
