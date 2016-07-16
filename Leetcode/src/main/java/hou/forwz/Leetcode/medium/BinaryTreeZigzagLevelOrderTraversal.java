package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午10:10:53
 */

public class BinaryTreeZigzagLevelOrderTraversal {

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		boolean reverse = false;
		while (!queue.isEmpty()) {

			// System.out.println(queue);
			Queue<TreeNode> helpQueue = new LinkedList<>();

			List<Integer> list = new ArrayList<>();

			while (!queue.isEmpty()) {
				TreeNode cur = queue.poll();
				list.add(cur.val);
				if (cur.left != null)
					helpQueue.offer(cur.left);
				if (cur.right != null)
					helpQueue.offer(cur.right);
			}

			if (reverse) {
				ret.add(deal(list));
			} else {
				ret.add(list);
			}
			reverse = !reverse;
			if (helpQueue.isEmpty())
				break;

			queue = new LinkedList<>(helpQueue);
		}

		return ret;

	}

	private List<Integer> deal(List<Integer> list) {
		List<Integer> ret = new ArrayList<>();
		for (int i : list)
			ret.add(0, i);
		return ret;
	}

}
