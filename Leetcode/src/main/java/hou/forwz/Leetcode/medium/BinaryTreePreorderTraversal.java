package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日上午1:06:44
 */

public class BinaryTreePreorderTraversal {

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		Stack<TreeNode> stack = new Stack<>();

		while (root != null || !stack.isEmpty()) {
			if (root != null) {
				ret.add(root.val);
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop().right;
			}

		}
		return ret;

	}

}
