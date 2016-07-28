package hou.forwz.Leetcode.medium;

import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月29日上午12:46:12
 */

public class BinarySearchTreeIterator2 {
	class BSTIterator {
		private Stack<TreeNode> stack = new Stack<TreeNode>();

		public BSTIterator(TreeNode root) {
			pushAll(root);
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode tmpNode = stack.pop();
			pushAll(tmpNode.right);
			return tmpNode.val;
		}

		private void pushAll(TreeNode node) {
			for (; node != null; stack.push(node), node = node.left)
				;
		}
	}
}
