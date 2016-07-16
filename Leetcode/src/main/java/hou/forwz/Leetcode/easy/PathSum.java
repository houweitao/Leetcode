package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午9:28:51
 */

public class PathSum {

	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		else if (root.val == sum && root.left == null && root.right == null)
			return true;
		else
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

	}

}
