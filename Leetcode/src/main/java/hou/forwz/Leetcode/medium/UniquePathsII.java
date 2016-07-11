package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月12日上午1:08:41
 */

public class UniquePathsII {

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid[0][0]==1)
            return 0;
        
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;

		if (m == 0 || n == 0)
			return 0;

		int[][] map = new int[m][n];

		for (int i = m - 1; i >= 0; i--) {
			if (obstacleGrid[i][n - 1] == 1)
				break;
			map[i][n - 1] = 1;
		}
		for (int i = n - 1; i >= 0; i--) {
			if (obstacleGrid[m - 1][i] == 1)
				break;
			map[m - 1][i] = 1;
		}

		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				if (obstacleGrid[i][j] == 1)
					map[i][j] = 0;
				else
					map[i][j] = map[i + 1][j] + map[i][j + 1];
			}
		}

		return map[0][0];
	
    }

}
