package hou.forme.GooglePrepare.GooglePrepare.hard;

/**
 * @author houweitao
 * @date 2016年12月5日下午3:09:49
 */

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] is = new boolean[s.length() + 1][p.length() + 1];
		is[0][0] = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*')
				is[0][i + 1] = is[0][i - 1];
		}

		for (int i = 1; i <= s.length(); i++) {
			char ss = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j++) {
				char pp = p.charAt(j - 1);

				if (pp == ss || pp == '.')
					is[i][j] = is[i - 1][j - 1];
				else if (pp == '*') {
					if (p.charAt(i - 2) != ss && p.charAt(i - 2) != '.') {
						is[i][j] = is[i][j - 2];
					} else
						is[i][j] = is[i][j - 2] || is[i][j - 1] || is[i - 1][j - 1];
				} else
					is[i][j] = false;
			}
		}

		return is[s.length()][p.length()];
	}

}
