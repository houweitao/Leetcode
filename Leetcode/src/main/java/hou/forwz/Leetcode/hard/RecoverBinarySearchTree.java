package hou.forwz.Leetcode.hard;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年8月8日上午1:15:51
 */

public class RecoverBinarySearchTree {
	TreeNode leftMax;
	TreeNode rightMin;

	public void recoverTree(TreeNode root) {
		if (root == null)
			return;
		leftMax = root;
		getMax(root.left);
		rightMin = root;
		getMin(root.right);

		if (leftMax == rightMin) {
			System.out.println("!");
			recoverTree(root.left);
			recoverTree(root.right);
		} else {
			System.out.println("?");
			System.out.println(leftMax.val+","+rightMin.val);
			if (leftMax.val > rightMin.val) {
				System.out.println("1");
				swap(leftMax, rightMin);
			} else if (leftMax.val > root.val) {
				System.out.println("2");
				swap(leftMax, root);
			} else if (rightMin.val < root.val) {
				System.out.println("3");
				swap(rightMin, root);
			}
		}
	}

	private void swap(TreeNode leftMax, TreeNode root) {
		int tmp = leftMax.val;
		leftMax.val = root.val;
		root.val = tmp;
	}

	private void getMin(TreeNode right) {
		if (right == null)
			return;
		if (right.val <= rightMin.val) {
			rightMin = right;
		}
		getMin(right.right);
		getMin(right.left);
	}

	private void getMax(TreeNode left) {
		if (left == null)
			return;
		if (left.val >= leftMax.val) {
			leftMax = left;
		}
		getMax(left.right);
		getMax(left.left);
	}

}
