package hou.forwz.Leetcode.easy;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日下午9:59:13
 */

public class LowestCommonAncestorOfABinarySearchTree {

	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null || root == p || root == q)
			return root;
		else {
			TreeNode left = lowestCommonAncestor(root.left, p, q);
			TreeNode right = lowestCommonAncestor(root.right, p, q);

			if (left == null)
				return right;
			if (right == null)
				return left;

			return root;
		}
	}

}
