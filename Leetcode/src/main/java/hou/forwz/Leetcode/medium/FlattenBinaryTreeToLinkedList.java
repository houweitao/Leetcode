package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:47:34
 */

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		if (root == null)
			return;
		else if (root.left == null)
			flatten(root.right);

		else {
			flatten(root.left);

			TreeNode l = root.left;
			TreeNode p = l;
			while (p != null && p.right != null)
				p = p.right;

			p.right = root.right;
			root.right = l;
			root.left = null;
		}
	}

}
