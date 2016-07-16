package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日上午12:21:43
 */

public class SumRootToLeafNumbers {

	int all = 0;

	public int sumNumbers(TreeNode root) {
		if (root == null)
			return 0;
		else {
			help(root, 0);
			return all;
		}

	}

	private void help(TreeNode root, int last) {
		if (root.left == null && root.right == null) {
			all = all + 10 * last + root.val;
		} else {
			int next = 10 * last + root.val;
			if (root.left != null) {
				help(root.left, next);
			}
			if (root.right != null)
				help(root.right, next);
		}

	}

}
