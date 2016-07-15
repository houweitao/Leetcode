package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:34:15
 */

public class BalancedBinaryTree {

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		else {
			return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left)
					&& isBalanced(root.right);
		}
	}

	int depth(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(depth(root.left), depth(root.right));
	}

}
