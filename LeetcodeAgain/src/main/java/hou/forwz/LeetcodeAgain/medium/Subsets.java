package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月15日下午6:22:19
 */

public class Subsets {
	public static void main(String[] args) {
		Subsets sub = new Subsets();
		int[] nums = { 1, 2, 3 };
		System.out.println(sub.subsets(nums));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums.length == 0)
			return ret;
		List<Integer> tmp = new ArrayList<>();
		ret.add(tmp);

		for (int n : nums) {
			List<List<Integer>> help = new ArrayList<>();
			for (int i = 0; i < ret.size(); i++) {
				List<Integer> t = new ArrayList<>();
				t.addAll(ret.get(i));
				t.add(n);
				help.add(t);
			}
			ret.addAll(help);
		}

		return ret;
	}

}
