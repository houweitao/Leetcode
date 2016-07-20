package hou.forwz.Leetcode.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月21日上午1:48:59
 */

public class BinaryTreePostorderTraversal {

	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		if (root == null)
			return ret;

		stack.add(root);

		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();

			boolean a = cur.left == null && cur.right == null;
			boolean b = pre == cur.left || pre == cur.right;
			if (a || b) {
				ret.add(cur.val);
				stack.pop();
				pre = cur;
			} else {
				if (cur.right != null) {
					stack.push(cur.right);
					pre = stack.peek();
				}
				if (cur.left != null) {
					stack.push(cur.left);
					pre = stack.peek();
				}
			}
		}
		return ret;
	}

}
