package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月2日上午1:56:00
 */

public class SearchA2DMatrixII {

	public static void main(String[] args) {
		SearchA2DMatrixII sm = new SearchA2DMatrixII();
		int[][] matrix = { { 1 },{2} };
		System.out.println(sm.searchMatrix(matrix, 2));
	}

	public boolean searchMatrix(int[][] matrix, int target) {

		int m = matrix.length - 1;
		if (m == -1)
			return false;
		int n = matrix[0].length - 1;

		
		if (target < matrix[0][0] || target > matrix[m][n])
			return false;

		int index = findIndex(matrix, target);
		
		for(int i=0;i<=index;i++){
			if(find(matrix, target, i))
				return true;
		}
		return false;
	}

	private boolean find(int[][] map, int tar, int index) {
		if (map[index][0] > tar || map[index][map[0].length - 1] < tar)
			return false;
		else {
			int left = 0, right = map[0].length - 1;
			
			while (left <= right) {
				if (left == right)
					return map[index][left] == tar;

				int mid = (left + right) / 2;
				if (map[index][mid] > tar) {
					right = mid - 1;
				} else if (map[index][mid] < tar) {
					left = mid + 1;
				} else
					return true;
			}
			return false;
		}
	}

	private int findIndex(int[][] map, int tar) {
		int m = map.length - 1;

		int up = 0, down = m;

		while (up <= down) {
			if (up == down)
				return up;
			else if (up + 1 == down) {
				if (map[down][0] <= tar)
					return down;
				else
					return up;
			}

			int mid = (up + down) / 2;
			if (map[mid][0] > tar) {
				down = mid;
			} else if (map[mid][0] < tar)
				up = mid;
			else
				return mid;
		}

		return -1;
	}

}
