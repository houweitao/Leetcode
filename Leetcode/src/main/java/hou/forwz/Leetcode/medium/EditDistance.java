package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月13日下午10:02:00
 */

public class EditDistance {

	public int minDistance(String left, String right) {
		
		int[][] map = new int[left.length() + 1][right.length() + 1];

		for (int i = 0; i <= left.length(); i++)
			map[i][0] = i;
		for (int i = 0; i <= right.length(); i++)
			map[0][i] = i;

		for (int i = 1; i <= left.length(); i++) {
			for (int j = 1; j <= right.length(); j++) {
				int changeLeft = map[i - 1][j] + 1;
				int changeRight = map[i][j - 1] + 1;
				int same = left.charAt(i - 1) == right.charAt(j - 1) ? map[i - 1][j - 1] : map[i - 1][j - 1] + 1;

				map[i][j] = Math.min(same, Math.min(changeLeft, changeRight));
			}
		}

		return map[left.length()][right.length()];
	}

}
