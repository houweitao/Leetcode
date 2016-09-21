package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年9月18日下午8:15:12
 */

public class Permutations2 {
	public static void main(String[] args) {
		Permutations2 per = new Permutations2();
		int[] nums = { 1, 2, 2 };
		per.print(nums);
	}

	void print(int[] nums) {
		boolean[] visited = new boolean[nums.length];
		List<Integer> tmp = new ArrayList<>();
		dfs(tmp, visited, nums);
	}

	void dfs(List<Integer> tmp, boolean[] visited, int[] nums) {
		if (tmp.size() == nums.length) {
			print(tmp);
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1])
					continue;

				visited[i] = true;
				tmp.add(nums[i]);
				dfs(tmp, visited, nums);
				tmp.remove(tmp.size() - 1);
				visited[i] = false;
			}
		}

	}

	private void print(List<Integer> tmp) {
		System.out.println(tmp);
	}
}
