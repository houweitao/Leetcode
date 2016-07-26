package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * @author houweitao
 * @date 2016年7月27日上午12:17:06
 */

public class CourseSchedule2 {
	boolean[] visited;

	public boolean canFinish(int numCourses, int[][] pre) {
		Node[] nodes = new Node[numCourses];
		visited = new boolean[numCourses];
		for (int i = 0; i < numCourses; i++)
			nodes[i] = new Node(i);

		for (int i = 0; i < pre.length; i++) {
			nodes[pre[i][1]].next.add(nodes[pre[i][0]]);
		}
		for (int i = 0; i < nodes.length; i++)
			if (!help(nodes, i))
				return false;
		return true;

	}

	private boolean help(Node[] nodes, int pos) {
		if (pos == nodes.length)
			return true;
		else if (visited[pos])
			return false;
		else {
			visited[pos] = true;

			for (Node next : nodes[pos].next) {
				if (!help(nodes, next.val))
					return false;
			}

			visited[pos] = false;
		}

		return true;
	}

	class Node {
		int val;
		List<Node> next = new LinkedList<>();

		Node(int val) {
			this.val = val;
		}
	}
}
