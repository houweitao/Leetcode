package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月13日上午1:40:05
 */

public class SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0)
					deal(matrix, i, j);

			}
		}
	}

	private void deal(int[][] matrix, int x, int y) {
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[i][y] != 0)
				matrix[i][y] = Integer.MAX_VALUE;
		}
		
		for(int i=0;i<matrix[0].length;i++){
			if(matrix[x][i]!=0)
				matrix[x][i]=Integer.MAX_VALUE;
		}
	}

}
