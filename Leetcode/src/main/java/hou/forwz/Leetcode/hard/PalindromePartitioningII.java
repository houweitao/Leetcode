package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月29日上午2:20:27
 */

public class PalindromePartitioningII {
	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		System.out.println(pp.minCut("abcccb"));
	}

	public int minCut(String s) {
		int m = s.length();
		boolean[][] yes = new boolean[s.length()][s.length()];

		for (int i = 0; i < m; i++)
			yes[i][i] = true;
		for (int i = 0; i < m - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				yes[i][i + 1] = true;
		}
		for (int j = 2; j < m; j++) {
			for (int i = 0; i < m; i++) {
				if ((i + j < m) && s.charAt(i) == s.charAt(i + j) && yes[i + 1][i + j - 1])
					yes[i][i + j] = true;
			}
		}

//		print(yes);

		return min(yes, 0);
	}

	private void print(boolean[][] yes) {
		for (int i = 0; i < yes.length; i++) {
			for (int j = 0; j < yes.length; j++)
				System.out.print(yes[i][j] + ",");
			System.out.println();
		}
		System.out.println();

	}

	private int min(boolean[][] yes, int pos) {
		int min = Integer.MAX_VALUE;

		if (pos == yes.length)
			return 0;
		if (yes[pos][yes.length - 1])
			return 0;
		for (int i = yes.length - 1; i >= pos; i--) {
			int cur = 0;
			if (yes[pos][i]) {
				cur = 1 + min(yes, i + 1);
			} else
				cur = Integer.MAX_VALUE;
			min = Math.min(min, cur);
		}

		return min;
	}

}
