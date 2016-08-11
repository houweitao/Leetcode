package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月11日下午11:54:02
 * @理解 重要的的去理解题意。去掉的位置有什么特征？不一样则无影响，一样则需多加考虑。带她玩和不带她玩。2种选择
 * @end 2016年08月12日00:25:07
 */

public class DistinctSubsequences {
	public static void main(String[] args) {
		DistinctSubsequences ds = new DistinctSubsequences();
		System.out.println(ds.numDistinct("a", "b"));
	}

	public int numDistinct(String s, String t) {
		if (t.length() == 0)
			return 1;
		if (s.length() == 0)
			return 0;
		int[][] map = new int[t.length() + 1][s.length() + 1];
		for (int i = 0; i < map[0].length; i++) {
			map[0][i] = 1;
		}

		for (int i = 1; i <= t.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (t.charAt(i - 1) != s.charAt(j - 1)) {
					map[i][j] = map[i][j - 1];
				} else {
					map[i][j] = map[i][j - 1] // 不带当前玩
							+ map[i - 1][j - 1];// 带当前玩
				}
			}
		}
		return map[t.length()][s.length()];

	}

}
