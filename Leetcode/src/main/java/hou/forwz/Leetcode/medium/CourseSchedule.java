package hou.forwz.Leetcode.medium;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import hou.forwz.Leetcode.structure.Graph;

/**
 * @author houweitao
 * @date 2016年7月22日上午1:50:15
 */

public class CourseSchedule {

	boolean[] all;

	public boolean canFinish(int numCourses, int[][] pre) {
		all = new boolean[numCourses + 1];
		if (numCourses < 2)
			return true;
		if (pre.length < 2)
			return true;

		Map<Integer, Graph> map = new HashMap<>();
		for (int i = 0; i < numCourses; i++)
			map.put(i, new Graph(i));

		for (int i = 0; i < pre.length; i++) {
			int ke = pre[i][0], need = pre[i][1];

			Graph g = map.get(need);
			g.next.add(map.get(ke));

		}

		for (int i = 0; i < numCourses - 1; i++) {
			if (!all[i]) {
				boolean[] visit = new boolean[numCourses + 1];
				if (judge(map.get(i), visit))
					return false;
			}
		}
		return true;
	}

	private boolean judge(Graph node, boolean[] visit) {
		List<Graph> next = node.next;
		all[node.val] = true;
		if (next.size() == 0)
			return false;
		if (visit[node.val]) {
			return true;
		} else {
			for (Graph g : next) {
				visit[node.val] = true;
				if (!!all[g.val] && judge(g, visit)) {
					return true;
				}
				visit[node.val] = false;
			}

			return false;
		}
	}

}
