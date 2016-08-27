package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月27日下午4:48:48
 */

public class DungeonGame {
	public static void main(String[] args) {
		int[][] dungeon = { { 0, -3 } };
		DungeonGame dg = new DungeonGame();
		System.out.println(dg.calculateMinimumHP(dungeon));
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int[][] min = new int[dungeon.length][dungeon[0].length];
		for (int i = dungeon.length - 1; i >= 0; i--) {
			for (int j = dungeon[0].length - 1; j >= 0; j--) {
				if (i == min.length - 1 && j == min[0].length - 1) {
					min[i][j] = Math.max(1, 1 - dungeon[i][j]);
				} else if (i == min.length - 1) {
					min[i][j] = Math.max(1, min[i][j + 1] - dungeon[i][j]);
				} else if (j == min[0].length - 1) {
					min[i][j] = Math.max(1, min[i + 1][j] - dungeon[i][j]);
				} else {
					if (min[i + 1][j] < min[i][j + 1]) {
						min[i][j] = Math.max(1, min[i + 1][j] - dungeon[i][j]);
					} else {
						min[i][j] = Math.max(1, min[i][j + 1] - dungeon[i][j]);
					}
				}
			}
		}

		return min[0][0];
	}

}
