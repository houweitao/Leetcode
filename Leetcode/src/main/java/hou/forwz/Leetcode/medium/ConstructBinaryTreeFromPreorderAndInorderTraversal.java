package hou.forwz.Leetcode.medium;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日下午9:24:23
 */

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		return help(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
	}

	private TreeNode help(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
		if (preRight < preLeft || inRight < inLeft)
			return null;
		else if (preLeft == preRight)
			return new TreeNode(preorder[preLeft]);
		else {
			TreeNode root = new TreeNode(preorder[preLeft]);

			int pos = -1;
			for (int i = inLeft; i <= inRight; i++) {
				if (inorder[i] == preorder[preLeft]) {
					pos = i;
					break;
				}
			}

			if (pos == -1)
				return null;
			else {
				TreeNode left = help(preorder, preLeft + 1, preLeft + pos - inLeft, inorder, inLeft, pos - 1);
				TreeNode right = help(preorder, preLeft + pos + 1 - inLeft, preRight, inorder, pos + 1, inRight);

				root.left = left;
				root.right = right;

				return root;
			}

		}
	}

}
