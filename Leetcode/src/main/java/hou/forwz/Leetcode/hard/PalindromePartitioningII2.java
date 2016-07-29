package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月30日上午12:52:07
 * 类比coin change
 */

public class PalindromePartitioningII2 {
	public static void main(String[] args) {
		PalindromePartitioningII2 pp = new PalindromePartitioningII2();
		System.out.println(pp.minCut("abcccb"));
	}

	public int minCut(String s) {
		int[] record = new int[s.length()];
		for (int i = 0; i < s.length(); i++)
			record[i] = i;

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

		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j <= i; j++) {
				if (yes[j][i])
					if (j==0)
						record[i] = Math.min(record[i], 0);
					else
						record[i] = Math.min(record[i], 1 + record[j - 1]);
			}
		}
		return record[m - 1];

	}

	private void print(boolean[][] yes) {
		for (int i = 0; i < yes.length; i++) {
			for (int j = 0; j < yes.length; j++)
				System.out.print(yes[i][j] + ",");
			System.out.println();
		}
		System.out.println();

	}

}
