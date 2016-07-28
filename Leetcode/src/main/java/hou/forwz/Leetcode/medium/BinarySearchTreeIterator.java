package hou.forwz.Leetcode.medium;

import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月29日上午12:23:52
 */

public class BinarySearchTreeIterator {
	/**
	 * Definition for binary tree public class TreeNode { int val; TreeNode
	 * left; TreeNode right; TreeNode(int x) { val = x; } }
	 */

	// 左子树中序遍历
	public class BSTIterator {
		TreeNode root;
		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();
			this.root = root;
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty() || root != null;
		}

		/** @return the next smallest number */
		public int next() {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}

			TreeNode t = stack.pop();
			root = t.right;
			return t.val;

		}
	}

	/**
	 * Your BSTIterator will be called like this: BSTIterator i = new
	 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
	 */
}
