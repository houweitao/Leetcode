package hou.forwz.LeetcodeAgain.hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日上午12:17:41
 */

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();

		if (root == null)
			return ret;

		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		TreeNode pre = null;
		while (!stack.isEmpty()) {
			TreeNode cur = stack.peek();

			boolean a = cur.left == null && cur.right == null;
			boolean b = pre == cur.left || pre == cur.right;

			if (a || b) {
				ret.add(stack.pop().val);
				pre = cur;
			} else {
				if (cur.right != null) {
					stack.push(cur.right);
					pre = cur.right;
				}
				if (cur.left != null) {
					stack.push(cur.left);
					pre = cur.left;
				}
			}
		}
		return ret;
	}
}
