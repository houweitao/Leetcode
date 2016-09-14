package hou.forwz.LeetcodeAgain.medium;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午5:06:53
 */

public class CountCompleteTreeNodes2 {
	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int sum = 0;
		while (root != null) {
			int left = getDep(root.left);
			int right = getDep(root.right);

			if (left == right) {
				System.out.println(left + "," + right);
				sum += 2 << left;
				root = root.right;
			} else {
				System.out.println(left + "," + right);
				sum += 2 << right;
				root = root.left;
			}
		}
		return sum;
	}

	private int getDep(TreeNode right) {
		if (right == null)
			return 0;

		TreeNode p = right;
		int ret = 1;
		while (p.left != null) {
			ret++;
			p = p.left;
		}
		return ret;
	}
}
