package hou.forme.GooglePrepare.GooglePrepare.medium;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年12月6日下午1:22:36
 * @tips 细心啊！&& 写成了||
 * @end 2016年12月06日13:45:58
 */

public class KthSmallestElementInABST {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);

		KthSmallestElementInABST ks = new KthSmallestElementInABST();
		System.out.println(ks.kthSmallest(root, 2));
	}

	private static int number = 0;
	private static int count = 0;

	public int kthSmallestBeautiful(TreeNode root, int k) {
		count = k;
		helper(root);
		return number;
	}

	public void helper(TreeNode n) {
		if (n.left != null)
			helper(n.left);
		count--;
		if (count == 0) {
			number = n.val;
			return;
		}
		if (n.right != null)
			helper(n.right);
	}

	public int kthSmallest(TreeNode root, int k) {
		Node node = build(root);
		if (k > node.sum)
			return -1;

		return findK(node, k);
	}

	private int findK(Node node, int k) {
		if (k <= node.leftNum)
			return findK(node.left, k);
		else if (k == node.leftNum + 1)
			return node.val;
		else
			return findK(node.right, k - node.leftNum - 1);
	}

	private Node build(TreeNode root) {
		if (root == null)
			return null;
		else if (root.left == null && root.right == null) {
			Node ret = new Node(root.val);
			ret.leftNum = 0;
			ret.rightNum = 0;
			ret.sum = 1;
			return ret;
		}

		Node ret = new Node(root.val);
		Node left = build(root.left);
		Node right = build(root.right);

		int leftSum = left == null ? 0 : left.sum;
		int rightSum = right == null ? 0 : right.sum;
		ret.sum = 1 + (leftSum) + rightSum;
		ret.leftNum = leftSum;
		ret.rightNum = rightSum;
		ret.left = left;
		ret.right = right;
		return ret;
	}

	class Node {
		int val;
		Node left;
		Node right;
		int sum;
		int leftNum;
		int rightNum;

		public Node(int x) {
			val = x;
			leftNum = 0;
			rightNum = 0;
			sum = 1;
		}

	}
}
