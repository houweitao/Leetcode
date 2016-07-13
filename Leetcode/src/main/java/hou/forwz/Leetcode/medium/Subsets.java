package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月14日上午1:42:16
 */

public class Subsets {

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if(nums.length==0)
			return ret;
		
		List<Integer> tmp = new ArrayList<>();
		ret.add(tmp);

		for (int n : nums) {
			List<List<Integer>> help = new ArrayList<>();
			for (int j = 0; j < ret.size(); j++) {
				List<Integer> cur = new ArrayList<>();
				cur.add(n);
				cur.addAll(ret.get(j));
				help.add(cur);
			}
			ret.addAll(help);
		}
		
		return ret;
	}

}
