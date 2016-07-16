package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午11:05:30
 */

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
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

			ret.add(list);

			if (helpQueue.isEmpty())
				break;

			queue = new LinkedList<>(helpQueue);
		}

		List<List<Integer>> reallyRet = new ArrayList<>();

		for (int i = 0; i < ret.size(); i++) {
			reallyRet.add(0, ret.get(i));
		}

		return reallyRet;
	}

}
