package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:22:37
 */

public class MaximumDepthOfBinaryTree {

	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return Math.max(maxDepth(root.left) + 1, maxDepth(root.right) + 1);
	}

}
