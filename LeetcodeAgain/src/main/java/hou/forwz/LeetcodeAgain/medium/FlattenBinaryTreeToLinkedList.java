package hou.forwz.LeetcodeAgain.medium;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午1:12:30
 */

public class FlattenBinaryTreeToLinkedList {

	public void flatten(TreeNode root) {
		help(root);
	}

	private TreeNode help(TreeNode root) {
		if (root == null)
			return null;
		else {
			TreeNode left = help(root.left);
			TreeNode right = help(root.right);

			root.right = left;
			root.left = null;
			TreeNode p = root;
			while (p.right != null) {
				p = p.right;
			}
			p.right = right;
			return root;
		}
	}

}
