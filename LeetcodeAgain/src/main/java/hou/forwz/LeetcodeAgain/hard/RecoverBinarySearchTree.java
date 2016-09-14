package hou.forwz.LeetcodeAgain.hard;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日上午11:57:59
 */

public class RecoverBinarySearchTree {
	TreeNode leftMax;
	TreeNode rightMin;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		leftMax = root;
		rightMin = root;

		getLeftMax(root.left);
		getRightMin(root.right);

		if (leftMax == rightMin) {
			recoverTree(root.left);
			recoverTree(root.right);
		} else {
			if (leftMax.val > rightMin.val) {
				swap(leftMax, rightMin);
			} else if (leftMax.val == root.val)
				swap(leftMax, root);
			else
				swap(root, rightMin);
		}

	}

	private void swap(TreeNode left, TreeNode right) {
		int tmp = left.val;
		left.val = right.val;
		right.val = tmp;
	}

	private void getRightMin(TreeNode right) {
		if (right == null)
			return;
		else {
			if (right.val < leftMax.val)
				rightMin = right;
			getRightMin(right.left);
			getRightMin(right.right);
		}
	}

	private void getLeftMax(TreeNode left) {
		if (left == null)
			return;
		else {
			if (left.val > leftMax.val)
				leftMax = left;
			getLeftMax(left.left);
			getLeftMax(left.right);
		}
	}

}
