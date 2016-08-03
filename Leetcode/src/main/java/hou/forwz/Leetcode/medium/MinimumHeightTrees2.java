package hou.forwz.Leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年8月4日上午12:12:14
 */

public class MinimumHeightTrees2 {
	public List<Integer> findMinHeightTreesMe(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<>();
		if (n <= 1) {
			leaves.add(0);
			return leaves;
		}

		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			map.put(i, new HashSet<Integer>());
			int left = edges[i][0], right = edges[i][1];
			map.get(left).add(right);
			map.get(right).add(left);
		}

		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			if (entry.getValue().size() == 1) {
				leaves.add(entry.getKey());
			}
		}

		while (n > 2) {
			List<Integer> newLeaves = new ArrayList<>();

			for (Integer i : leaves) {
				Set<Integer> cur = map.get(i);
				for (Integer j : cur) {
					map.get(i).remove(j);
					map.get(j).remove(i);
					n--;// 取除了一个叶子
					if (map.get(j).size() == 1)
						newLeaves.add(j);
				}
			}

			leaves = newLeaves;
		}
		return leaves;
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> leaves = new ArrayList<>();
		if (n <= 1) {
			leaves.add(0);
			return leaves;
		}

		// Construct adjencent graph
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++)
			graph.put(i, new HashSet<Integer>());
		for (int[] e : edges) {
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		// Add leaves which have one leaf
		for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1)
				leaves.add(i);
		}

		// Remove leaves level by level
		while (n > 2) {
			List<Integer> newLeaves = new ArrayList<>();
			for (int leaf : leaves) {
				for (int nb : graph.get(leaf)) {
					// Remove connection
					graph.get(leaf).remove(nb);
					graph.get(nb).remove(leaf);
					n--;
					if (graph.get(nb).size() == 1) {
						newLeaves.add(nb);
					}
				}
			}
			leaves = newLeaves;
		}
		return leaves;
	}
}
