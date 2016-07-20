package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月21日上午2:09:20
 */

public class BinaryTreeRightSideView {
	public static void main(String[] args) {
		BinaryTreeRightSideView bt = new BinaryTreeRightSideView();
		TreeNode node = new TreeNode(1);
		node.left = new TreeNode(2);
		node.right = new TreeNode(3);
		node.left.right = new TreeNode(4);

		System.out.println(bt.rightSideView(node));
	}

	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ret = new LinkedList<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if (root == null)
			return ret;
		queue.offer(root);

		while (!queue.isEmpty()) {
			// System.out.println(queue);
			Queue<TreeNode> cur = new LinkedList<>();

			while (queue.size() > 0) {
				TreeNode node = queue.poll();
				// System.out.println(node.val);
				if (node.left != null)
					cur.offer(node.left);
				if (node.right != null)
					cur.offer(node.right);

				if (queue.size() == 0) {
					ret.add(node.val);
				}
			}
			queue = cur;

		}
		return ret;

	}

}
