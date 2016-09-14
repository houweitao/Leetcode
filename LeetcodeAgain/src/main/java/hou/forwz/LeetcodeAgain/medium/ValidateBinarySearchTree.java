package hou.forwz.LeetcodeAgain.medium;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日上午11:48:15
 */

public class ValidateBinarySearchTree {

	public boolean isValidBST(TreeNode root) {
		return help(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean help(TreeNode root, long min, long max) {
		if (root == null)
			return true;
		else if (root.val <= min || root.val >= max)
			return false;
		else {
			return help(root.left, min, root.val) && help(root.right, root.val, max);
		}
	}

}
