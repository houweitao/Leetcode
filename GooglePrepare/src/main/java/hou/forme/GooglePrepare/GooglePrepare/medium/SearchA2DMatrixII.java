package hou.forme.GooglePrepare.GooglePrepare.medium;

/**
 * @author houweitao
 * @date 2016年12月6日下午2:27:02
 */

public class SearchA2DMatrixII {
	public boolean searchMatrixOther(int[][] matrix, int target) {
		int m = matrix.length, n = matrix[0].length, i = 0, j = n - 1;
		while (i < m && j >= 0) {
			if (matrix[i][j] == target)
				return true;
			else if (matrix[i][j] < target)
				i++;
			else
				j--;
		}
		return false;
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0)
			return false;

		int minHeng = findMinHeng(matrix, target);
		System.out.println(minHeng);
		if (minHeng == -1)
			return false;
		int maxHeng = findMaxHeng(matrix, target);
		System.out.println(maxHeng);
		if (maxHeng == -1)
			return false;

		for (int i = minHeng; i <= maxHeng; i++) {
			if (yes(matrix, i, target))
				return true;
		}
		return false;
	}

	private boolean yes(int[][] matrix, int pos, int target) {
		int left = 0, right = matrix[pos].length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (matrix[pos][mid] == target)
				return true;
			else if (matrix[pos][mid] > target)
				right = mid - 1;
			else
				left = mid + 1;
		}
		return false;
	}

	private int findMinHeng(int[][] matrix, int target) {
		int left = 0, right = matrix.length - 1;
		int pos = matrix[0].length - 1;
		if (matrix[0][pos] >= target)
			return 0;
		if (matrix[right][pos] < target)
			return -1;

		while (left < right) {
			if (left + 1 == right) {
				if (matrix[left][pos] >= target)
					return left;
				else if (matrix[right][pos] >= target) {
					return right;
				} else
					return -1;
			}

			int mid = (left + right) / 2;
			if (matrix[mid][pos] > target) {
				right = mid;
			} else if (matrix[mid][pos] < target)
				left = mid;
			else
				return mid;
		}

		return -1;
	}

	private int findMaxHeng(int[][] matrix, int target) {
		if (matrix[0][0] > target)
			return -1;
		if (matrix[matrix.length - 1][0] <= target)
			return matrix.length - 1;

		int left = 0, right = matrix.length - 1;
		while (left < right) {
			if (left + 1 == right) {
				if (matrix[left][0] <= target)
					return left;
				else if (matrix[right][0] <= target)
					return right;
				return -1;
			}

			int mid = (left + right) / 2;
			if (matrix[mid][0] < target) {
				left = mid;
			} else if (matrix[mid][0] > target) {
				right = mid;
			} else
				return mid;
		}

		return 0;
	}
}
