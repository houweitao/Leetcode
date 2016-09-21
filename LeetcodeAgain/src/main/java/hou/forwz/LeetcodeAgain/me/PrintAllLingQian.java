package hou.forwz.LeetcodeAgain.me;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月21日下午9:27:01
 */

public class PrintAllLingQian {
	public static void main(String[] args) {
		int[] nums = { 1, 2, 5, 7 };
		int target = 20;
		PrintAllLingQian pa = new PrintAllLingQian();
		List<List<Integer>> ret = pa.print(nums, target);
		for (List<Integer> list : ret) {
			System.out.println(list);
		}
	}

	List<List<Integer>> print(int[] nums, int target) {
		List<List<Integer>> ret = new ArrayList<>();
		if (nums == null || nums.length == 0 || target < 1)
			return ret;
		List<Integer> tmp = new ArrayList<>();

		Arrays.sort(nums);
		dfs(nums, 0, target, tmp, ret);
		return ret;
	}

	private void dfs(int[] nums, int pos, int target, List<Integer> tmp, List<List<Integer>> ret) {
		if (target == 0) {
			ret.add(new ArrayList<>(tmp));
		} else if (target < 0) {
			return;
		} else {
			for (int i = pos; i < nums.length; i++) {
				tmp.add(nums[i]);
				dfs(nums, i, target - nums[i], tmp, ret);
				tmp.remove(tmp.size() - 1);
			}
		}
	}

}

// nums={1，2，5，7}, target=20;
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 7]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 7]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 5, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 7]
//[1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2]
//[1, 1, 1, 1, 1, 1, 1, 1, 2, 5, 5]
//[1, 1, 1, 1, 1, 1, 1, 1, 5, 7]
//[1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 5]
//[1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 7]
//[1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2]
//[1, 1, 1, 1, 1, 1, 2, 2, 5, 5]
//[1, 1, 1, 1, 1, 1, 2, 5, 7]
//[1, 1, 1, 1, 1, 1, 7, 7]
//[1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 5]
//[1, 1, 1, 1, 1, 2, 2, 2, 2, 7]
//[1, 1, 1, 1, 1, 5, 5, 5]
//[1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2]
//[1, 1, 1, 1, 2, 2, 2, 5, 5]
//[1, 1, 1, 1, 2, 2, 5, 7]
//[1, 1, 1, 1, 2, 7, 7]
//[1, 1, 1, 2, 2, 2, 2, 2, 2, 5]
//[1, 1, 1, 2, 2, 2, 2, 2, 7]
//[1, 1, 1, 2, 5, 5, 5]
//[1, 1, 1, 5, 5, 7]
//[1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2]
//[1, 1, 2, 2, 2, 2, 5, 5]
//[1, 1, 2, 2, 2, 5, 7]
//[1, 1, 2, 2, 7, 7]
//[1, 2, 2, 2, 2, 2, 2, 2, 5]
//[1, 2, 2, 2, 2, 2, 2, 7]
//[1, 2, 2, 5, 5, 5]
//[1, 2, 5, 5, 7]
//[1, 5, 7, 7]
//[2, 2, 2, 2, 2, 2, 2, 2, 2, 2]
//[2, 2, 2, 2, 2, 5, 5]
//[2, 2, 2, 2, 5, 7]
//[2, 2, 2, 7, 7]
//[5, 5, 5, 5]

