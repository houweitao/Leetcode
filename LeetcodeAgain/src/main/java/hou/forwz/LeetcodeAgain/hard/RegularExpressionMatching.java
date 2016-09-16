package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月28日下午10:17:18
 * @nice https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
 */

public class RegularExpressionMatching {

	public boolean isMatch(String s, String p) {
		boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
		match[0][0] = true;

		for (int i = 1; i < match[0].length; i++) {
			if (p.charAt(i - 1) == '*' && match[0][i - 2])
				match[0][i] = true;
		}

		for (int i = 1; i <= s.length(); i++) {
			char shu = s.charAt(i - 1);
			for (int j = 1; j <= p.length(); j++) {
				char heng = p.charAt(j - 1);

				if (heng == '.')
					match[i][j] = match[i - 1][j - 1];
				else if (heng == '*') {
					if (p.charAt(j - 2) != shu && p.charAt(j - 2) != '.') {
						match[i][j] = match[i][j - 2];
					} else {
						
						if(match[i][j-2]||match[i][j-1]||match[i-1][j])
							match[i][j]=true;
//						// null
//						if (match[i - 1][j])
//							match[i][j] = true;
//						// one
//						if (match[i][j - 2])
//							match[i][j] = true;
//						// mul
//						if (match[i][j - 1])
//							match[i][j] = true;
					}
				} else
					match[i][j] = match[i - 1][j - 1] && heng == shu;

			}
		}
		return match[s.length()][p.length()];
	}

}
