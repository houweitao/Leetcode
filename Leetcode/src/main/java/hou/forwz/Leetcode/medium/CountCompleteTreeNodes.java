package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月29日上午1:38:42
 */

public class CountCompleteTreeNodes {
	Map<TreeNode, Integer> depth = new HashMap<>();

	public int countNodes(TreeNode root) {

		int leftDeep = deep(root.left);
		int rightDeep = deep(root.right);

		if (leftDeep == rightDeep) {
			return (int) (Math.pow(2, leftDeep) + countNodes(root.right));
		} else
			return (int) (Math.pow(2, rightDeep)) + countNodes(root.left);

	}

	private int deep(TreeNode root) {
		int dep = 0;
		while (root != null) {
			root = root.left;
			dep++;
		}
		return dep;
	}

	private int deep2(TreeNode root) {
		if (depth.containsKey(root))
			return depth.get(root);
		else if (root == null)
			return 0;
		else {
			int dep = 1 + deep(root.left);
			depth.put(root, dep);
			return dep;
		}
	}

}
