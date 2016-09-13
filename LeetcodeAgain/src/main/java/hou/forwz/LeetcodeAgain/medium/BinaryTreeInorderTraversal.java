package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日上午12:30:41
 */

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();

		TreeNode root = new TreeNode(1);
		TreeNode left = new TreeNode(2);
		TreeNode right = new TreeNode(3);

		root.left = left;
		root.right = right;

		System.out.println(bt.inorderTraversal(root));
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null || !stack.isEmpty()) {
			if (root == null) {
				root = stack.pop();
				ret.add(root.val);
				root = root.right;
			} else {
				stack.push(root);
				root = root.left;
			}
		}
		return ret;
	}

}
