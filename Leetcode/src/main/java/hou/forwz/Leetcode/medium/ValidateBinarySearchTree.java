package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月14日上午2:23:42
 */

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean help(TreeNode root, Long min, Long max) {
		if (root == null)
			return true;
		else {
			if (root.val > min && root.val < max) {
				return help(root.left, min, (long) root.val) && help(root.right, (long) root.val, max);
			}
			return false;
		}

	}

}
