package hou.forwz.Leetcode.hard;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午11:46:18
 */

public class BinaryTreeMaximumPathSum {
	Map<TreeNode, Integer> pathRec = new HashMap<>();

	public static void main(String[] args) {
		BinaryTreeMaximumPathSum bt = new BinaryTreeMaximumPathSum();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		System.out.println(bt.maxPathSum(node));
	}

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int lp = path(root.left), rp = path(root.right);

		lp = lp > 0 ? lp : 0;
		rp = rp > 0 ? rp : 0;
		int cur = (lp) + (rp) + root.val;
		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);

		// System.out.println("cur = " + root.val + "," + lp + "," + rp);
		// System.out.println(root.val + " " + cur + ":" + left + "," + right);

		return Math.max(left, Math.max(cur, right));
	}

	private int path(TreeNode root) {
		if (root == null)
			return 0;
		else {
			if (pathRec.containsKey(root))
				return pathRec.get(root);
			else {
				int max = Math.max(Math.max(path(root.left), path(root.right)) + root.val, root.val);
				pathRec.put(root, max);
				return max;
			}
		}
	}

}
