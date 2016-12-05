package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月5日下午4:22:07
 * @end 2016年12月05日16:30:39
 */

public class WildcardMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] is = new boolean[s.length() + 1][p.length() + 1];
		is[0][0] = true;

		for (int i = 1; i < is[0].length; i++) {
			char c = p.charAt(i - 1);
			if (c == '*' && is[0][i - 1]) {
				is[0][i] = true;
			} else
				break;
		}

		for (int i = 1; i <= s.length(); i++) {
			char ss = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j++) {
				char pp = p.charAt(j - 1);

				if (pp == '?' || pp == ss)
					is[i][j] = is[i - 1][j - 1];
				else if (pp == '*') {
					is[i][j] = is[i][j - 1] || is[i - 1][j - 1] || is[i - 1][j];
				} else
					is[i][j] = false;
			}
		}

		return is[s.length()][p.length()];

	}

}
