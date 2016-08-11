package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月12日上午12:47:27
 * @toyoung 2016年08月12日01:26:53
 */

public class DungeonGame {

	// min[i][j]=1 代表只有能到这，就可以拯救公主了
	public int calculateMinimumHP(int[][] dungeon) {
		int[][] min = new int[dungeon.length][dungeon[0].length];
		for (int i = min.length - 1; i >= 0; i--) {
			for (int j = min[0].length - 1; j >= 0; j--) {
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
