package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午12:44:55
 */

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		boolean shun = false;
		while (!queue.isEmpty()) {
			shun = !shun;
			Queue<TreeNode> tmp = new LinkedList<>();
			List<Integer> cur = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				if (shun)
					cur.add(node.val);
				else
					cur.add(0, node.val);
				if (node.left != null)
					tmp.offer(node.left);
				if (node.right != null)
					tmp.offer(node.right);
			}
			ret.add(cur);
			queue = tmp;
		}
		return ret;

	}

}
