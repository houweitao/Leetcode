package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午12:48:59
 */

public class BinaryTreeInorderTraversal {
	public static void main(String[] args) {
		BinaryTreeInorderTraversal bt = new BinaryTreeInorderTraversal();
		TreeNode node = new TreeNode(1);
		node.right = new TreeNode(2);
		node.right.left = new TreeNode(3);

		System.out.println(bt.inorderTraversal(node));
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
