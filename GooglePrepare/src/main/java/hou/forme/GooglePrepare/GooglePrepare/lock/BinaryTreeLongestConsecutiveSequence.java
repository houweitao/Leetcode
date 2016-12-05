package hou.forme.GooglePrepare.GooglePrepare.lock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import hou.forme.GooglePrepare.GooglePrepare.structure.Node;

/**
 * @author houweitao
 * @date 2016年12月4日下午12:25:51
 * @end 2016年12月04日12:50:08
 * @url http://www.1point3acres.com/bbs/thread-214648-1-1.html
 */

public class BinaryTreeLongestConsecutiveSequence {

	Set<Node> visited = new HashSet<>();

	int getMaxLen(Node root) {
		if (root == null)
			return 0;

		Queue<Node> queue = new LinkedList<>();
		queue.offer(root);
		int ret = 1;

		while (queue.isEmpty()) {
			Node cur = queue.poll();

			// #1
			int max = dfs(cur, queue);
			ret = Math.max(ret, max);
			// end

			// #2
			if (visited.contains(cur)) {
				int curmax = dfs(cur);
				ret = Math.max(ret, curmax);
			}
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
			// end
		}

		return ret;
	}

	private int dfs(Node cur) {
		if (cur == null)
			return 0;
		else {
			int left = 1, right = 1;
			if (cur.left != null && cur.left.val == cur.val + 1) {
				visited.add(cur.left);
				left = 1 + dfs(cur.left);
			}
			if (cur.right != null && cur.right.val == cur.val + 1) {
				visited.add(cur.right);
				left = 1 + dfs(cur.right);
			}
			return Math.max(left, right);
		}
	}

	private int dfs(Node cur, Queue<Node> queue) {
		if (cur == null)
			return 0;
		else {
			int left = 1, right = 1;
			if (cur.left != null) {
				if (cur.left.val == cur.val + 1) {
					left = 1 + dfs(cur.left);
				} else {
					queue.offer(cur.left);
				}
			}
			if (cur.right != null) {
				if (cur.right.val == cur.val + 1) {
					left = 1 + dfs(cur.right);
				} else {
					queue.offer(cur.right);
				}
			}
			return Math.max(left, right);
		}
	}

}
