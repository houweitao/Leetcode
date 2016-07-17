package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日下午10:05:48
 */

public class LowestCommonAncestorofABinaryTree {

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
