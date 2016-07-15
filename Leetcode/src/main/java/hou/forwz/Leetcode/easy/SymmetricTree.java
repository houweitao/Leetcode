package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:17:27
 */

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root) {
		return root == null || help(root.left, root.right);
	}

	private boolean help(TreeNode left, TreeNode right) {
		if (left == null || right == null)
			return left == right;
		if (left.val != right.val)
			return false;
		else {
			return help(left.left, right.right) && help(left.right, right.left);
		}
	}

}
