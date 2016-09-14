package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月15日上午1:12:23
 */

public class KthSmallestElementInABST {
	Map<TreeNode, Integer> num = new HashMap<>();

	public int kthSmallest(TreeNode root, int k) {
		buildMap(root);
		num.put(null, 0);
		TreeNode p = root;
		while (true) {
			int left = num.get(p.left);
			int right = num.get(p.right);

			if (k == left + 1) {
				return p.val;
			} else if (k <= left) {
				p = p.left;
			} else {
				p = p.right;
				k = k - left - 1;
			}
		}
	}

	private int buildMap(TreeNode root) {
		if (num.containsKey(root))
			return num.get(root);
		else if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			num.put(root, 1);
			return 1;
		} else {
			int left = buildMap(root.left);
			int right = buildMap(root.right);

			int sum = 1 + left + right;
			num.put(root, sum);
			return sum;
		}
	}

}
