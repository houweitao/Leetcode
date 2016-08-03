package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月4日上午12:36:27
 */

public class CourseScheduleII2 {
	public static void main(String[] args) {
		CourseScheduleII2 cs = new CourseScheduleII2();
		int[][] ke = { { 0, 1 },{2,1}};
//		,  { 1, 2 } };
		// , { 5, 4 }, { 4, 3 }, { 3, 2 } };
		int[] ret = cs.findOrder(3, ke);

		for (int i : ret)
			System.out.print(i + "->");
	}

	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] ret = new int[numCourses];
		List<Integer> heads = new LinkedList<>();
		Map<Integer, Set<Integer>> map = new HashMap<>();
		Map<Integer, Set<Integer>> before = new HashMap<>();

		if (numCourses <= 1) {
			heads.add(0);
			return new int[] { 0 };
		}

		for (int i = 0; i < numCourses; i++) {
			map.put(i, new HashSet<Integer>());
			before.put(i, new HashSet<Integer>());
			// heads.add(i);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			int first = prerequisites[i][1];
			int second = prerequisites[i][0];

			map.get(first).add(second);
			before.get(second).add(first);
		}

		for (Map.Entry<Integer, Set<Integer>> entry : before.entrySet()) {
			if (entry.getValue().size() == 0)
				heads.add(entry.getKey());
		}

		// System.out.println(heads);

		if (heads.size() == 0)
			return new int[] {};

		// System.out.println(heads);

		int pos = 0;
		while (true) {
			System.out.println(pos);
			System.out.println(before);
			System.out.println(heads);
			if (heads.size() == 0) {
				if (pos != numCourses)
					return new int[] {};
				else
					return ret;
			}
			List<Integer> newHeads = new LinkedList<>();
			for (int i : heads) {
				ret[pos++] = i;
				if(pos==numCourses)
					return ret;
				Set<Integer> cur = map.get(i);
				for (int y : cur) {
					before.get(y).remove(i);
//					map.get(i).remove(y);
					if (before.get(y).size() == 0) {
						newHeads.add(y);
					}
				}
			}
			heads = newHeads;
			// if (heads.size() == 0)
			// break;

			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		return ret;
	}
}
