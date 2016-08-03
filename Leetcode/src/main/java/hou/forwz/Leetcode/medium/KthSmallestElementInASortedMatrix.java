package hou.forwz.Leetcode.medium;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年8月3日下午11:02:17
 */

public class KthSmallestElementInASortedMatrix {

	public int kthSmallest(int[][] matrix, int k) {
		boolean[][] visited = new boolean[matrix.length][matrix.length];

		PriorityQueue<Point> queue = new PriorityQueue<>(k, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				if (o1.val > o2.val)
					return 1;
				else if (o1.val < o2.val)
					return -1;
				else
					return 0;
			}
		});
		queue.offer(new Point(matrix[0][0], 0, 0));
		visited[0][0] = true;

		int i = 0;
		while (!queue.isEmpty()) {
			Point cur = queue.poll();
			i++;
			if (i == k)
				return cur.val;

			if (in(matrix, cur.x + 1, cur.y) && !visited[cur.x + 1][cur.y]) {
				Point down = new Point(matrix[cur.x + 1][cur.y], cur.x + 1, cur.y);
				visited[cur.x + 1][cur.y] = true;
				queue.offer(down);
			}
			if (in(matrix, cur.x, 1 + cur.y) && !visited[cur.x][cur.y + 1]) {
				Point right = new Point(matrix[cur.x][1 + cur.y], cur.x, cur.y + 1);
				visited[cur.x][cur.y + 1] = true;
				queue.offer(right);
			}

		}

		return -1;
	}

	private boolean in(int[][] matrix, int i, int j) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		else
			return false;
	}

	class Point {
		int val;
		int x;
		int y;

		Point(int val, int x, int y) {
			this.val = val;
			this.x = x;
			this.y = y;
		}
	}
}
