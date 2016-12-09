package hou.forme.GooglePrepare.GooglePrepare.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author houweitao
 * @date 2016年12月10日上午12:43:34
 * @end 2016年12月10日01:16:43
 * @ps 写的太慢了！
 */

public class PacificAtlanticWaterFlow {
	public static void main(String[] args) {
		PacificAtlanticWaterFlow paw = new PacificAtlanticWaterFlow();
		int[][] matrix = { { 1, 1 }, { 1, 1 }, { 1, 1 } };

		// { { 1, 2, 2, 3, 5 }, { 3, 2, 3, 4, 4 }, { 2, 4, 5, 3, 1 }, { 6, 7, 1,
		// 4, 5 },
		// { 5, 1, 1, 2, 4 } };

		paw.pacificAtlantic(matrix);
	}

	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> ret = new ArrayList<>();
		if (matrix == null || matrix.length == 0)
			return ret;

		boolean[][] pac = new boolean[matrix.length][matrix[0].length];
		boolean[][] atl = new boolean[matrix.length][matrix[0].length];

		boolean[][] visited = new boolean[matrix.length][matrix[0].length];

		Queue<int[]> pacific = new LinkedList<>();
		Queue<int[]> atlantic = new LinkedList<>();

		for (int i = 0; i < matrix.length; i++) {
			pacific.add(new int[] { i, 0 });
			atlantic.add(new int[] { i, matrix[0].length - 1 });
		}

		for (int i = 0; i < matrix[0].length; i++) {
			pacific.add(new int[] { 0, i });
			atlantic.add(new int[] { matrix.length - 1, i });
		}

		while (!pacific.isEmpty()) {
			int[] cur = pacific.poll();
			visited[cur[0]][cur[1]] = true;

			if (!pac[cur[0]][cur[1]]) {
				pac[cur[0]][cur[1]] = true;
				deal(pacific, cur[0], cur[1], matrix, visited);
			}
		}

		visited = new boolean[matrix.length][matrix[0].length];
		while (!atlantic.isEmpty()) {
			int[] cur = atlantic.poll();
			if (!atl[cur[0]][cur[1]]) {
				atl[cur[0]][cur[1]] = true;
				deal(atlantic, cur[0], cur[1], matrix, visited);
			}
		}

		// print(pac);
		// print(atl);

		boolean[][] last = new boolean[matrix.length][matrix[0].length];
		for (int i = 0; i < pac.length; i++) {
			for (int j = 0; j < pac[0].length; j++) {
				if (pac[i][j] && atl[i][j]) {
					last[i][j] = true;
					ret.add(new int[] { i, j });
				}
			}
		}

		// print(last);
		return ret;
	}

	private void print(boolean[][] pac) {
		for (int i = 0; i < pac.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < pac[0].length; j++) {
				int s = pac[i][j] ? 1 : 0;
				sb.append(s + " ");
			}
			System.out.println(sb);
		}
		System.out.println();
	}

	private void deal(Queue<int[]> queue, int i, int j, int[][] matrix, boolean[][] visited) {
		if (in(i + 1, j, matrix) && !visited[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
			queue.offer(new int[] { i + 1, j });
			visited[i][j] = true;
		}
		if (in(i - 1, j, matrix) && !visited[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
			queue.offer(new int[] { i - 1, j });
			visited[i][j] = true;
		}
		if (in(i, j + 1, matrix) && !visited[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
			queue.offer(new int[] { i, j + 1 });
			visited[i][j] = true;
		}
		if (in(i, j - 1, matrix) && !visited[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
			queue.offer(new int[] { i, j - 1 });
			visited[i][j] = true;
		}
	}

	private boolean in(int i, int j, int[][] matrix) {
		if (i >= 0 && i < matrix.length && j >= 0 && j < matrix[0].length)
			return true;
		else
			return false;
	}

}
