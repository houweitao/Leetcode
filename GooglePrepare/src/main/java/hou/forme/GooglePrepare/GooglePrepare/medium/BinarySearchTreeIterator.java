package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.Stack;

import hou.forme.GooglePrepare.GooglePrepare.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年12月5日下午9:25:15
 * @end 2016年12月05日21:31:46
 */

public class BinarySearchTreeIterator {
	public class BSTIterator {
		Stack<TreeNode> stack;

		public BSTIterator(TreeNode root) {
			stack = new Stack<>();

			TreeNode head = root;
			while (head != null) {
				stack.push(head);
				head = head.left;
			}
		}

		/** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		/** @return the next smallest number */
		public int next() {
			TreeNode top = stack.pop();
			TreeNode cur = top.right;
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			return top.val;
		}
	}
}
