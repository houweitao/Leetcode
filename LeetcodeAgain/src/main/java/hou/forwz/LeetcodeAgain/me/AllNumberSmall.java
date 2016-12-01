package hou.forwz.LeetcodeAgain.me;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年11月29日下午6:32:38
 * @url http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=209673&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3089%5D%5Bvalue%5D%5B2%5D%3D2%26searchoption%5B3089%5D%5Btype%5D%3Dcheckbox%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 */

public class AllNumberSmall {
	public static void main(String[] args) {
		AllNumberSmall an = new AllNumberSmall();

		List<Integer> list = new ArrayList<>();
		list.add(0);
		list.add(3);
		list.add(7);
		list.add(8);
		List<Integer> ret = an.getAll(list, 8700);
		for (Integer str : ret)
			System.out.println(str);
	}

	List<Integer> getAll(List<Integer> list, int target) {
		List<Integer> ret = new ArrayList<>();

		for (int i : list) {
			if (i == 0)
				continue;
			dfs(list, i, target, ret);
		}
		return ret;
	}

	private void dfs(List<Integer> list, int pre, int target, List<Integer> ret) {
		if (nice(pre, target)) {
			ret.add(pre);
			for (int i : list) {
				dfs(list, pre * 10 + i, target, ret);
			}
		}
	}

	private boolean nice(int pre, int target) {
		if (pre < target)
			return true;
		else
			return false;
	}
}
