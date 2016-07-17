package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月17日下午10:50:49
 */

public class GuessNumberHigherOrLowerII {
	public static void main(String[] args) {
		GuessNumberHigherOrLowerII gn = new GuessNumberHigherOrLowerII();
		System.out.println("res:" + gn.getMoneyAmount(10));
	}

	public int getMoneyAmount(int n) {
		int[][] map = new int[n + 2][n + 2];

		for (int i = 1; i <= n - 1; i++) {
			map[i][i + 1] = i;
			// map[i][i] = i;
		}
		// map[n][n] = 1;

		for (int i = 1; i <= n - 2; i++)
			map[i][i + 2] = i + 1;

		// print(map);

		for (int j = 3; j < n; j++) {// distance
			for (int i = 1; i + j <= n; i++) {// begin
				int min = Integer.MAX_VALUE;
				for (int k = i; k <= i + j; k++) {
					int maybe = k + Math.max(map[i][k - 1], map[k + 1][i + j]);
					// System.out.println(i + "," + k + "," + (i + j) + ":" +
					// maybe);
					min = Math.min(min, maybe);
				}
				map[i][i + j] = min;
			}
		}

		System.out.println();
		// print(map);

		return map[1][n];

	}

	private void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[0].length; j++)
				System.out.print(map[i][j] + " ");
			System.out.println();
		}
		System.out.println();
	}

}
