package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月14日上午2:20:46
 */

public class SameTree {

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		else if (p == null || q == null)
			return false;
		else if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		} else
			return false;
	}

}
