package hou.forwz.Leetcode.medium;

import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月21日下午11:22:17
 */

public class BSTIterator {
	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator(TreeNode root) {
		makeStack(root);
	}

	private void makeStack(TreeNode root) {
		TreeNode p = root;
		while (p != null) {
			stack.push(p);
			p = p.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
		TreeNode tmpNode = stack.pop();
		makeStack(tmpNode.right);
		return tmpNode.val;
	}

}
