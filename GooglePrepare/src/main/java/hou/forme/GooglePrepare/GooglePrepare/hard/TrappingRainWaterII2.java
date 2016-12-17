package hou.forme.GooglePrepare.GooglePrepare.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author houweitao
 * @date 2016年12月16日下午6:49:05
 * @end 2016年12月16日19:26:55
 */

public class TrappingRainWaterII2 {
	public static void main(String[] args) {
		TrappingRainWaterII2 tr = new TrappingRainWaterII2();
		int[][] heightMap = { { 1, 4, 3, 1, 3, 2 }, { 3, 2, 1, 3, 2, 4 }, { 2, 3, 3, 2, 3, 1 } };
		System.out.println(tr.trapRainWater(heightMap));
	}

	public int trapRainWater(int[][] heightMap) {
		if (heightMap == null || heightMap.length == 0)
			return 0;

		boolean[][] added = new boolean[heightMap.length][heightMap[0].length];

		PriorityQueue<Dot> queue = new PriorityQueue<>(10, new Comparator<Dot>() {

			@Override
			public int compare(Dot o1, Dot o2) {
				return Integer.compare(o1.height, o2.height);
			}
		});

		for (int i = 0; i < heightMap.length; i++) {
			queue.offer(new Dot(i, 0, heightMap[i][0]));
			added[i][0] = true;
			queue.offer(new Dot(i, heightMap[0].length - 1, heightMap[i][heightMap[0].length - 1]));
			added[i][heightMap[0].length - 1] = true;
		}
		for (int i = 0; i < heightMap[0].length; i++) {
			queue.offer(new Dot(0, i, heightMap[0][i]));
			added[0][i] = true;
			queue.offer(new Dot(heightMap.length - 1, i, heightMap[heightMap.length - 1][i]));
			added[heightMap.length - 1][i] = true;
		}
		int[] sum = new int[1];
		sum[0] = 0;
		while (queue.size() > 0) {
			Dot dot = queue.poll();
			// System.out.println("poll " + dot);

			deal(queue, dot.x - 1, dot.y, sum, heightMap, added, dot.height);
			deal(queue, dot.x + 1, dot.y, sum, heightMap, added, dot.height);
			deal(queue, dot.x, dot.y + 1, sum, heightMap, added, dot.height);
			deal(queue, dot.x, dot.y - 1, sum, heightMap, added, dot.height);
		}
		return sum[0];
	}

	private void deal(PriorityQueue<Dot> queue, int x, int y, int[] sum, int[][] heightMap, boolean[][] added,
			int last) {
		Dot up = makeDot(x, y, heightMap, added, last);
		if (up != null) {
			sum[0] += Math.max(0, up.height - heightMap[up.x][up.y]);
			queue.offer(up);
			// System.out.println(up);
			// System.out.println(Math.max(0, up.height -
			// heightMap[up.x][up.y]));
		}
	}

	private Dot makeDot(int x, int y, int[][] heightMap, boolean[][] added, int last) {
		if (in(heightMap, x, y) && !added[x][y]) {
			added[x][y] = true;
			return new Dot(x, y, Math.max(heightMap[x][y], last));
		} else
			return null;
	}

	private boolean in(int[][] map, int x, int y) {
		if (x >= 0 && x < map.length && y >= 0 && y < map[0].length)
			return true;
		else
			return false;
	}

	class Dot {
		int x;
		int y;
		int height;

		public Dot(int x, int y, int height) {
			super();
			this.x = x;
			this.y = y;
			this.height = height;
		}

		@Override
		public String toString() {
			return "Dot [x=" + x + ", y=" + y + ", height=" + height + "]";
		}

	}
}
