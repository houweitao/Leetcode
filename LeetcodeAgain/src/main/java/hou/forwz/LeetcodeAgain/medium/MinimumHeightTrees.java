package hou.forwz.LeetcodeAgain.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年9月14日下午6:28:32
 */

public class MinimumHeightTrees {
	// from
	Map<Integer, Set<Integer>> map = new HashMap<>();

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < edges.length; i++) {
			int one = edges[i][0];
			int two = edges[i][1];

			map.get(one).add(two);
			map.get(two).add(one);
		}

		while (map.size() > 2) {
			List<Integer> leaf = new ArrayList<>();
			for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
				if (entry.getValue().size() == 1) {
					leaf.add(entry.getKey());
				}
			}

			for (int i : leaf) {
				List<Integer> cur = new ArrayList<>(map.get(i));
				map.get(cur.get(0)).remove(i);
				map.remove(i);
			}

//			map = tmp;
			System.out.println(leaf);
		}

		List<Integer> ret = new ArrayList<>(map.keySet());
		return ret;

	}

}
