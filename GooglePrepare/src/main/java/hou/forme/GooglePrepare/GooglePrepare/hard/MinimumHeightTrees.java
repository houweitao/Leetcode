package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年12月6日下午9:29:56
 * @end 2016年12月06日21:51:51
 * @ps 用叶子和不用叶子的区别
 */

public class MinimumHeightTrees {
	public static void main(String[] args) {
		int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
		System.out.println(new MinimumHeightTrees().findMinHeightTrees(4, edges));
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		Map<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			Set<Integer> set = new HashSet<>();
			map.put(i, set);
		}
		for (int i = 0; i < edges.length; i++) {
			map.get(edges[i][0]).add(edges[i][1]);
			map.get(edges[i][1]).add(edges[i][0]);
		}

		System.out.println(map);

		Set<Integer> leaf = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (map.get(i).size() == 1) {
				leaf.add(i);
			}
		}
		System.out.println(leaf);

		while (map.size() > 2) {
			Set<Integer> next = new HashSet<>();
			for (int out : leaf) {
				int neib = map.get(out).iterator().next();
				map.remove(out);
				map.get(neib).remove(out);
				if (map.get(neib).size() == 1)
					next.add(neib);
			}
			leaf = next;
		}

		List<Integer> ret = new ArrayList<>();
		for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
			ret.add(entry.getKey());
		}
		return ret;
	}

}
