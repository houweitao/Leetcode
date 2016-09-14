package hou.forwz.LeetcodeAgain.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午4:48:14
 */

public class CountCompleteTreeNodes {
	Map<TreeNode, Integer> dep = new HashMap<>();

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;
		buildMap(root);
		dep.put(null, 0);

		int sum = 0;
		while (true) {
			sum++;

			if (root.left == null && root.right == null) {
				sum++;
				break;
			}

			int left = dep.get(root.left);
			int right = dep.get(root.right);

			if (left == right) {
				root = root.right;
				sum = sum + (int) Math.pow(2, left) - 1;
			} else {
				sum = sum + (int) Math.pow(2, right) - 1;
				root = root.left;
			}
		}
		return sum;
	}

	private int buildMap(TreeNode root) {
		if (dep.containsKey(root))
			return dep.get(root);
		else if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			dep.put(root, 1);
			return 1;
		} else {
			int ret = Math.max(buildMap(root.left), buildMap(root.right)) + 1;
			dep.put(root, ret);
			return ret;
		}
	}

}
