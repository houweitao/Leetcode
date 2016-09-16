package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月16日下午1:04:55
 * @timeout 2016年09月16日13:45:31
 */

public class CourseSchedule {
	public static void main(String[] args) {
		int[][] pre = { { 2, 0 }, { 2, 1 } };

		CourseSchedule cs = new CourseSchedule();
		System.out.println(cs.canFinish(3, pre));
	}

	public boolean canFinish(int numCourses, int[][] pre) {
		if (numCourses < 2)
			return true;
		Node[] nodes = new Node[numCourses];

		for (int i = 0; i < numCourses; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < pre.length; i++) {
			nodes[pre[i][1]].add(nodes[pre[i][0]]);
			nodes[pre[i][0]].pre.add(nodes[pre[i][1]]);
		}

		List<Node> preNode = new ArrayList<>();
		for (int i = 0; i < numCourses; i++) {
			if (nodes[i].pre.size() == 0)
				preNode.add(nodes[i]);
		}

		if (preNode.size() == 0)
			return false;

		Queue<Node> queue = new LinkedList<>();
		queue.addAll(preNode);
		boolean[] visited = new boolean[numCourses];

		System.out.println(queue);

		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			visited[cur.val] = true;
			for (Node n : cur.next) {
				queue.offer(n);
				n.dep = cur.dep + 1;
				if (n.dep >= numCourses)
					return false;
			}
		}

		for (Boolean b : visited) {
			if (!b)
				return false;
		}

		return true;
	}

	class Node {
		int val;
		int dep;
		Set<Node> next;
		Set<Node> pre;

		Node(int val) {
			dep = 0;
			this.val = val;
			next = new HashSet<>();
			pre = new HashSet<>();
		}

		void add(Node node) {
			next.add(node);
		}

		@Override
		public String toString() {
			return val + "";
		}
	}

}
