package hou.forme.GooglePrepare.GooglePrepare.lock;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年12月11日下午3:51:23
 */

public class ClosestBinarySearchTreeValue {
	int closestValue(TreeNode root, int target) {
		if (root == null)
			return -1;
		else
			return help(root, target);
	}

	private int help(TreeNode root, int target) {
		if (root == null)
			return Integer.MAX_VALUE;
		else if (root.val == target)
			return target;
		else if (root.val > target) {
			return Math.min(root.val - target, help(root.left, target));
		} else {
			return Math.min(target - root.val, help(root.right, target));
		}
	}
}
