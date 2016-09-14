package hou.forwz.LeetcodeAgain.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.LeetcodeAgain.structure.TreeNode;

/**
 * @author houweitao
 * @date 2016年9月14日下午12:54:53
 */

public class BinaryTreeLevelOrderTraversalII {

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		List<List<Integer>> ret = new ArrayList<>();
		if (root == null)
			return ret;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.offer(root);
		while (!queue.isEmpty()) {
			Queue<TreeNode> tmp = new LinkedList<>();
			List<Integer> cur = new ArrayList<>();
			while (!queue.isEmpty()) {
				TreeNode node = queue.poll();
				cur.add(node.val);
				if (node.left != null)
					tmp.offer(node.left);
				if (node.right != null)
					tmp.offer(node.right);
			}
			ret.add(0, cur);
			queue = tmp;
		}
		return ret;

	}

}
