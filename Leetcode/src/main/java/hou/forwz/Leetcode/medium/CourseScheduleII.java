package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年7月27日上午12:43:12
 */

public class CourseScheduleII {

	public static void main(String[] args) {
		CourseScheduleII cs = new CourseScheduleII();
		int[][] ke = { { 1, 0 }, { 0, 1 } };
		// { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } };
		int[] ret = cs.findOrder(2, ke);

		for (int i : ret)
			System.out.print(i + "->");
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		Node[] nodes = new Node[numCourses];
		for (int i = 0; i < numCourses; i++)
			nodes[i] = new Node(i);

		for (int i = 0; i < prerequisites.length; i++) {
			int cur = prerequisites[i][0];
			int need = prerequisites[i][1];

			nodes[cur].before.add(nodes[need]);
			nodes[need].next.add(nodes[cur]);
		}

		// for (int i = 0; i < nodes.length; i++) {
		// System.out.println(i + ": " + nodes[i].before + ";" + nodes[i].next);
		// }

		Map<Node, Integer> distance = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();

		for (int i = 0; i < nodes.length; i++) {
			if (nodes[i].next.size() == 0) {
				distance.put(nodes[i], 0);
				queue.offer(nodes[i]);
			}
		}
		
		if(distance.size()==0)
			return null;

		int maxDis = 0;
		while (!queue.isEmpty()) {
			Node cur = queue.poll();
			int dis = distance.get(cur);
			for (Node next : cur.before) {
				distance.put(next, dis + 1);
				maxDis = Math.max(maxDis, dis + 1);
				if (maxDis >= numCourses)
					return null;
				queue.offer(next);
			}
		}

//		 System.out.println(distance.size());

		List<List<Node>> list = new LinkedList<>();
		for (int i = 0; i <= maxDis; i++)
			list.add(new LinkedList<Node>());

		for (int i = 0; i < nodes.length; i++) {
			int dis = distance.get(nodes[i]);
			list.get(dis).add(nodes[i]);
		}

		int[] ret = new int[nodes.length];
		int pos = numCourses - 1;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 0; j < list.get(i).size(); j++) {
				ret[pos--] = list.get(i).get(j).val;
			}
		}

		return ret;
	}

	class Node {
		int val;
		List<Node> before = new LinkedList<>();
		List<Node> next = new LinkedList<>();

		Node(int val) {
			this.val = val;
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return val + "";
		}
	}
}
