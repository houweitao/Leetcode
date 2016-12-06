package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月6日下午12:10:42
 * @ps 思想真的赞👍，有点meeting room 的意思？然后更稳妥的方法是用一个 pair对，记录下开始和结束的线 目前方法如果有重合比较难办吧..2016年12月06日12:48:34
 * @url http://www.programcreek.com/2014/06/leetcode-the-skyline-problem-java/
 */

public class TheSkylineProblem {
	public static void main(String[] args) {
		int[][] buildings = { { 2, 9, 10 }, { 3, 7, 15 }, { 5, 12, 12 }, { 15, 20, 10 }, { 19, 24, 8 } };
		List<int[]> ret = new TheSkylineProblem().getSkyline(buildings);
	}

	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]> ret = new ArrayList<>();

		if (buildings == null || buildings.length == 0 || buildings[0].length == 0)
			return ret;

		List<Edge> edges = new ArrayList<>();
		for (int[] building : buildings) {
			Edge startEdge = new Edge(building[0], building[2], true);
			edges.add(startEdge);
			Edge endEdge = new Edge(building[1], building[2], false);
			edges.add(endEdge);
		}

		Collections.sort(edges, new Comparator<Edge>() {

			@Override
			public int compare(Edge a, Edge b) {
				if (a.x != b.x) {
					return Integer.compare(a.x, b.x);
				}

				// 防止出现2个 x 坐标相同的开始天际线
				if (a.isStart && b.isStart) {
					return -Integer.compare(a.height, b.height);
				}

				// 先到先得 高的占优
				if (!a.isStart && !b.isStart) {
					return Integer.compare(a.height, b.height);
				}

				return a.isStart ? -1 : 1;
			}
		});

		for (Edge edge : edges) {
			System.out.println(edge);
		}

		PriorityQueue<Integer> heightHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());

		for (Edge edge : edges) {
			System.out.println("---");
			System.out.println(edge);
			System.out.println(heightHeap);
			if (edge.isStart) {
				if (heightHeap.isEmpty() || edge.height > heightHeap.peek()) {
					ret.add(new int[] { edge.x, edge.height });
				}
				heightHeap.add(edge.height);
			} else {
				heightHeap.remove(edge.height);
				System.out.println("remove: " + edge.height);
				if (heightHeap.isEmpty()) {
					ret.add(new int[] { edge.x, 0 });
				} else if (edge.height > heightHeap.peek()) {
					ret.add(new int[] { edge.x, heightHeap.peek() });
				}
			}
		}
		return ret;
	}

	class Edge {
		int x;
		int height;
		boolean isStart;

		public Edge(int x, int height, boolean isStart) {
			super();
			this.x = x;
			this.height = height;
			this.isStart = isStart;
		}

		@Override
		public String toString() {
			return "Edge [x=" + x + ", height=" + height + ", isStart=" + isStart + "]";
		}

	}
}
