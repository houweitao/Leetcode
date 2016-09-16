package hou.forwz.LeetcodeAgain.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月16日下午2:02:46
 */

public class CourseScheduleII {

	public static void main(String[] args) {
		int[][] pre = { { 1, 0 } };

		CourseScheduleII cs = new CourseScheduleII();
		System.out.println(cs.findOrder(2, pre));
	}

	public int[] findOrder(int numCourses, int[][] pre) {
		int[] ret = new int[numCourses];
		if (numCourses == 1) {
			ret[0] = 0;
			return ret;
		}

		Node[] nodes = new Node[numCourses];

		for (int i = 0; i < numCourses; i++) {
			nodes[i] = new Node(i);
		}

		for (int i = 0; i < pre.length; i++) {
			nodes[pre[i][1]].next.add(nodes[pre[i][0]]);
			nodes[pre[i][0]].pre.add(nodes[pre[i][1]]);
		}

		Set<Node> set = new HashSet<>();
		Set<Node> head = new HashSet<>();

		for (Node n : nodes) {
			set.add(n);
			if (n.pre.size() == 0)
				head.add(n);
		}

		// System.out.println("all: " + set);
		// System.out.println("head: " + head);

		int pos = 0;
		while (set.size() > 0 && head.size() > 0) {
			Set<Node> tmp = new HashSet<>();

			for (Node cur : head) {
				Set<Node> nextNodes = cur.next;
				for (Node nextNode : nextNodes) {
					nextNode.pre.remove(cur);
					if (nextNode.pre.size() == 0) {
						tmp.add(nextNode);
					}
				}
				set.remove(cur);
				ret[pos++] = cur.val;
			}

			head = tmp;
		}

		// System.out.println(set);
		// System.out.println(head);

		if (set.size() > 0)
			return new int[] {};
		else
			return ret;
	}

	class Node {
		int val;
		Set<Node> next;
		Set<Node> pre;

		Node(int val) {
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
