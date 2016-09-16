package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月16日上午3:01:53
 */

public class WildcardMatching2 {
	public boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[p.length() + 1][s.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*' && match[i - 1][0])
				match[i][0] = true;
			else
				break;
		}

		for (int i = 1; i < p.length(); i++) {
			char ii = p.charAt(i);
			for (int j = 1; j < s.length(); j++) {
				char jj = s.charAt(j);

				if (ii == '?') {
					if (match[i - 1][j - 1])
						match[i][j] = true;
				} else if (ii == '*') {
					if (match[i][j - 1]// duo?
							|| match[i - 1][j - 1]// one?
							|| match[i - 1][j]) // null?
					{
						match[i][j] = true;
					}
				} else {
					if (match[i - 1][j - 1] && jj == ii)
						match[i][j] = true;
				}
			}
		}
		return match[p.length()][s.length()];
	}
}
