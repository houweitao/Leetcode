package hou.forwz.Leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年7月16日下午9:54:42
 */

public class BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		BinaryTreeLevelOrderTraversal bt = new BinaryTreeLevelOrderTraversal();
		TreeNode node = new TreeNode(3);
		node.left = new TreeNode(4);
		node.right = new TreeNode(5);
		node.left.right = new TreeNode(6);
		System.out.println(bt.levelOrder(node));
	}

	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;

		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			
//			System.out.println(queue);
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

		return ret;
	}

}
