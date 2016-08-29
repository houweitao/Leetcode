package hou.forwz.LeetcodeAgain.hard;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年8月29日下午10:56:07
 */

public class BinaryTreeMaximumPathSum {
	Map<TreeNode, Integer> path = new HashMap<>();

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int lp = getPath(root.left);
		int rp = getPath(root.right);

		int cur = root.val + (lp < 0 ? 0 : lp) + (rp < 0 ? 0 : rp);

		int left = maxPathSum(root.left);
		int right = maxPathSum(root.right);

		return Math.max(cur, Math.max(left, right));
	}

	private int getPath(TreeNode root) {
		if (path.containsKey(root))
			return path.get(root);

		if (root == null)
			return 0;
		else {
			int add = Math.max(getPath(root.left), getPath(root.right));
			if (add < 0)
				add = 0;
			int he = root.val + add;
			path.put(root, he);
			return he;
		}
	}

}
