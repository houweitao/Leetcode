package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月7日上午1:21:33
 * @finally 2016年08月07日01:42:06
 */

public class WildcardMatching2 {

	public boolean isMatch(String s, String p) {
		int m = p.length(), n = s.length();

		boolean[][] map = new boolean[m + 1][n + 1];
		map[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (p.charAt(i - 1) == '*' && map[i - 1][0])
				map[i][0] = true;
		}

		for (int i = 1; i <= m; i++) {
			char shu = p.charAt(i - 1);
			for (int j = 1; j <= n; j++) {
				char heng = s.charAt(j - 1);

				if (shu == '?') {
					map[i][j] = map[i - 1][j - 1];
				} else if (shu == '*') {
					map[i][j] = map[i - 1][j - 1] || map[i][j - 1];
				} else {
					map[i][j] = map[i - 1][j - 1] && heng == shu;
				}
			}
		}

		return map[m][n];
	}

}
