package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日下午9:48:01
 */

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		return help(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

	}

	private TreeNode help(int[] inorder, int inl, int inr, int[] postorder, int pol, int por) {
		if (inl > inr || pol > por || (inr - inl) != (por - pol))
			return null;
		else if (inl == inr)
			return new TreeNode(inorder[inr]);
		else {
			int pos = -1;
			for (int i = inl; i <= inr; i++) {
				if (inorder[i] == postorder[por]) {
					pos = i;
					break;
				}
			}

			if (pos == -1)
				return null;

			else {
				TreeNode root = new TreeNode(postorder[por]);
				TreeNode left = help(inorder, inl, pos - 1, postorder, pol, pol + pos - 1 - inl);
				TreeNode right = help(inorder, pos + 1, inr, postorder, pol + pos - inl, por - 1);

				root.left = left;
				root.right = right;
				return root;
			}
		}

	}

}
