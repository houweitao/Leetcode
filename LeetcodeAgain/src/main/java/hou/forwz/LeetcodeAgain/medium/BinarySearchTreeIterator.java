package hou.forwz.LeetcodeAgain.medium;

import java.util.Stack;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午1:21:09
 */

public class BinarySearchTreeIterator {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	public class BSTIterator {
		TreeNode root;
		Stack<TreeNode> stack = new Stack<>();

		public BSTIterator(TreeNode root) {
			this.root = root;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty() || root != null;
		}

		/** @return the next smallest number */
		public int next() {
			if (hasNext()) {
				while (root != null) {
					stack.push(root);
					root = root.left;
				}

				TreeNode t = stack.pop();
				root = t.right;

				return t.val;
			} else
				return -1;

		}
	}

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */
}
