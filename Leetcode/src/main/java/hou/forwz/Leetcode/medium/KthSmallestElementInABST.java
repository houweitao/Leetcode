package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.Map;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月17日下午10:08:23
 */

public class KthSmallestElementInABST {

	Map<TreeNode, Integer> num = new HashMap<>();

	public static void main(String[] args) {
		KthSmallestElementInABST ks = new KthSmallestElementInABST();
		TreeNode root = new TreeNode(1);
		TreeNode right = new TreeNode(2);
		root.right = right;

		System.out.println(ks.kthSmallest(root, 2));
	}

	public int kthSmallest(TreeNode root, int k) {
		num.put(null, 0);
		count(root);

		System.out.println(num.get(root));
		System.out.println(num.size());

		return help(root, k).val;
	}

	private TreeNode help(TreeNode root, int k) {
		if (root == null)
			return null;

		int left = num.get(root.left);
		int right = num.get(root.right);

		if (left == 0 && right == 0 && k == 1)
			return root;

		if (k > num.get(root))
			return null;
		else if (k <= left && root.left != null)
			return help(root.left, k);
		else if (k == left + 1)
			return root;
		else if (root.right != null)
			return help(root.right, k - 1 - left);

		return null;
	}

	private int count(TreeNode root) {
		if (root == null)
			return 0;
		else if (root.left == null && root.right == null) {
			num.put(root, 1);
			return 1;
		} else if (num.containsKey(root))
			return num.get(root);
		else {
			int left = 0, right = 0;
			if (num.containsKey(root.left))
				left = num.get(root.left);
			else {
				left = count(root.left);
			}
			if (num.containsKey(root.right))
				right = num.get(root.right);
			else {
				right = count(root.right);
			}
			num.put(root, 1 + left + right);
			return 1 + left + right;
		}

	}

}
