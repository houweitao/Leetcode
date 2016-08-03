package hou.forwz.Leetcode.medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import hou.forwz.Leetcode.structure.Graph;

/**
 * @author houweitao
 * @date 2016年8月3日下午11:29:41
 * @result timeout
 */

public class MinimumHeightTrees {
	public static void main(String[] args) {
		MinimumHeightTrees mt = new MinimumHeightTrees();
		int[][] edges = { { 0, 1 }, { 0, 3 }, { 0, 2 }, { 4, 3 }, { 5, 4 } };
		System.out.println(mt.findMinHeightTrees(6, edges));
	}

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> ret = new LinkedList<>();

		if (n == 1) {
			ret.add(0);
			return ret;
		} else if (edges.length == 0)
			return ret;
		else if (edges.length == 1) {
			ret.add(0);
			ret.add(1);
			return ret;
		}

		Graph[] graphs = new Graph[n];
		graphs = buildMap(edges, n);

		for (Graph g : graphs)
			System.out.println(g);

		Queue<Graph> queue = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			if (graphs[i].next.size() > 1)
				queue.offer(graphs[i]);
		}

		int sum = Integer.MAX_VALUE;
		while (!queue.isEmpty()) {
			Graph cur = queue.poll();
			int res = deal(cur, n, sum);
			if (res < sum) {
				sum = res;
				ret.clear();
				ret.add(cur.val);
			} else if (res == sum)
				ret.add(cur.val);
		}

		return ret;
	}

	private int deal(Graph node, int n, int pre) {
		int[] nums = new int[n];
		boolean[] visited = new boolean[n];
		Queue<Graph> queue = new LinkedList<>();

		queue.add(node);
		visited[node.val] = true;

		int height = 0;
		while (!queue.isEmpty()) {
			height++;

			if (height > pre)
				return Integer.MAX_VALUE;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Graph cur = queue.poll();
				nums[cur.val] = height;
				for (Graph g : cur.next) {
					if (!visited[g.val]) {
						queue.offer(g);
						visited[g.val] = true;
					}
				}
			}
		}

		return height;
	}

	private Graph[] buildMap(int[][] edges, int n) {
		Graph[] graphs = new Graph[n];
		for (int i = 0; i < n; i++) {
			graphs[i] = new Graph(i);
		}
		for (int i = 0; i < edges.length; i++) {
			int left = edges[i][0], right = edges[i][1];
			graphs[left].next.add(graphs[right]);
			graphs[right].next.add(graphs[left]);
		}

		return graphs;
	}

}
