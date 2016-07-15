package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:25:15
 */

public class MinimumDepthOfBinaryTree {
	int min = Integer.MAX_VALUE;

	public int minDepth(TreeNode root) {
		if (root == null)
			return 0;
		help(root, 1);
		return min;
	}

	private void help(TreeNode root, int deep) {

		if (root == null)
			return;
		else {
			if (root.left == null && root.right == null) {
				min = Math.min(deep, min);
			} else {
				help(root.left, deep + 1);
				help(root.right, deep + 1);
			}
		}
	}

}
