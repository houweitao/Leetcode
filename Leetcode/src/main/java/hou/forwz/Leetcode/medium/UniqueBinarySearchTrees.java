package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月13日上午12:08:26
 */

public class UniqueBinarySearchTrees {
	public static void main(String[] args) {
		UniqueBinarySearchTrees ub = new UniqueBinarySearchTrees();
		System.out.println(ub.numTrees(8));
	}

	public int numTrees(int n) {
		if(n<1)
			return 0;
		
		int[][] map = new int[n + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			map[i][i] = 1;
		}
		for (int i = 1; i < n; i++) {
			map[i][i + 1] = 2;
		}

//		for (int i = 0; i <= n; i++) {
//			for (int j = 0; j < i; j++) {
//				map[i][j] = 1;
//			}
//		}

		for (int i = n; i >= 1; i--) {
			for (int j = i+2; j <= n; j++) {
				map[i][j] = count(map, i, j);
			}
		}

		return map[1][n];
	}

	private int count(int[][] map, int begin, int end) {
		int sum = 0;
		for (int i = begin; i <= end; i++) {
			int left = i == begin ? 1 : map[begin][i - 1];
			int right = i == end ? 1 : map[i + 1][end];
			sum = sum + left * right;
		}

		return sum;
	}

}
