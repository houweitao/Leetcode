package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月22日上午1:31:37
 */

public class HouseRobberIII {
	// https://discuss.leetcode.com/topic/39846/easy-to-understand-java/2
	public int rob(TreeNode root) {
		if (root == null)
			return 0;
		return Math.max(robInclude(root), robExclude(root));
	}

	public int robInclude(TreeNode node) {
		if (node == null)
			return 0;
		return robExclude(node.left) + robExclude(node.right) + node.val;
	}

	public int robExclude(TreeNode node) {
		if (node == null)
			return 0;
		return rob(node.left) + rob(node.right);
	}

	public int rob2(TreeNode root) {
		if (root == null)
			return 0;
		List<Integer> list = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			Queue<TreeNode> cur = new LinkedList<>();
			int sum = 0;
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				sum = sum + node.val;
				if (node.left != null)
					cur.offer(node.left);
				if (node.right != null)
					cur.offer(node.right);
			}
			queue = cur;
			list.add(sum);
		}

		System.out.println(list);

		int[] nums = new int[list.size()];
		for (int i = 0; i < nums.length; i++)
			nums[i] = list.get(i);

		return better(nums);

	}

	int better(int[] nums) {
		int[] help = new int[nums.length];
		help[0] = nums[0];
		if (nums.length == 1)
			return nums[0];
		help[1] = Math.max(nums[0], nums[1]);
		if (nums.length == 2)
			return help[1];

		help[2] = Math.max(nums[1], nums[0] + nums[2]);
		if (nums.length == 3)
			return help[2];

		for (int i = 3; i < nums.length; i++) {
			int last = nums[i] + help[i - 2];
			int sec = nums[i - 1] + help[i - 3];
			help[i] = Math.max(last, sec);
		}

		return help[help.length - 1];
	}

}
