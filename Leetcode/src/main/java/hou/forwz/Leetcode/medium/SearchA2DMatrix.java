package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月10日下午11:16:15
 */

public class SearchA2DMatrix {

	public static void main(String[] args) {
		SearchA2DMatrix sf = new SearchA2DMatrix();
		int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(sf.searchMatrix(matrix, 11));
	}

	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix[0][0] > target || matrix[matrix.length - 1][matrix[0].length - 1] < target)
			return false;
		else {
			int heng = findHeng(matrix, target);
			System.out.println("heng " + heng);
			if (heng == -1)
				return false;
			return find(matrix[heng], target);
		}

	}

	private boolean find(int[] nums, int tar) {
		if (nums[0] > tar || nums[nums.length - 1] < tar)
			return false;
		else {
			int left = 0, right = nums.length - 1;

			while (left <= right) {
				if (left == right) {
					if (nums[left] == tar)
						return true;
					else
						return false;
				} else {
					int mid = (left + right) / 2;
					if (nums[mid] == tar)
						return true;
					else if (nums[mid] > tar)
						right = mid - 1;
					else
						left = mid + 1;
				}
			}

		}

		return false;
	}

	private int findHeng(int[][] matrix, int tar) {
		int left = 0, right = matrix.length - 1;

		while (left <= right) {
			if (left == right) {
				if (matrix[left][0] <= tar)
					return left;
				else
					return -1;
			} else if (left + 1 == right) {
				if (matrix[left][0] > tar)
					return -1;
				else if (matrix[left][0] <= tar && matrix[right][0] > tar) {
					return left;
				} else
					return right;
			} else {
				int mid = (left + right) / 2;
				if (matrix[mid][0] == tar)
					return mid;
				else if (matrix[mid][0] > tar)
					right = mid;
				else
					left = mid;
			}
		}

		return -1;
	}

}
