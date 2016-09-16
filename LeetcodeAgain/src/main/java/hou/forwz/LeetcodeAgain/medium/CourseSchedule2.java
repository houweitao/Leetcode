package hou.forwz.LeetcodeAgain.medium;

import java.util.HashSet;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月16日下午1:45:23
 */

public class CourseSchedule2 {
	public static void main(String[] args) {
		int[][] pre = { { 1, 0 } };

		CourseSchedule2 cs = new CourseSchedule2();
		System.out.println(cs.canFinish(2, pre));
	}

	public boolean canFinish(int numCourses, int[][] pre) {
		if (numCourses < 2)
			return true;
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

//		System.out.println("all:   " + set);
//		System.out.println("head:  " + head);

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
			}
			head = tmp;
		}

//		System.out.println(set);
//		System.out.println(head);

		if (set.size() > 0)
			return false;
		else
			return true;
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
