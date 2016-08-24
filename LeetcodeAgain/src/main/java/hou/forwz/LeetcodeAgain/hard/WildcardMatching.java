package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月24日下午10:05:54
 */

public class WildcardMatching {
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		// String s = "abefcdsgiescdfimde", p = "ab*cd?i*de";
		String s = "ab", p = "ab*";
		// String s = "babaaababaabababbbbbbaabaabbabababbaababbaaabbbaaab";
		// String p = "***bba**a*bbba**aab**b";
		System.out.println(wm.isMatchWrong(s, p));
	}

	// *可以代表任何字符串，而非连续。理解题意啊同学！2016年08月24日22:38:46
	public boolean isMatchWrong(String s, String p) {
		boolean[][] match = new boolean[p.length() + 1][s.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= p.length(); i++) {
			if (p.charAt(i - 1) == '*' && match[i - 1][0])
				match[i][0] = true;
			else
				break;
		}

		for (int i = 1; i <= p.length(); i++) {
			char ii = p.charAt(i - 1);
			for (int j = 1; j <= s.length(); j++) {
				char jj = s.charAt(j - 1);

				if (ii == '?') {
					if (match[i - 1][j - 1])
						match[i][j] = true;
				} else if (ii == '*') {
					if (match[i][j - 1] // null
							|| match[i - 1][j - 1] // *==ii
							|| match[i - 1][j])// *==mult
						match[i][j] = true;
				} else {
					if (match[i - 1][j - 1] && jj == ii)
						match[i][j] = true;
				}

			}
		}

		return match[p.length()][s.length()];
	}

	public boolean isMatch(String s, String p) {
		// System.out.println("compare " + s + "," + p);

		if (s.length() == 0) {
			if (allStar(p))
				return true;

			return false;
		}

		if (p.length() == 0) {
			if (s.length() == 0)
				return true;
			else
				return false;
		}

		boolean[][] match = new boolean[p.length() + 1][s.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= p.length(); i++) {
			char ii = p.charAt(i - 1);

			// for (int j = i; j <= s.length(); j++) {
			if (s.length() < i) {
				return isMatch("", p.substring(i - 1));
			}
			char jj = s.charAt(i - 1);

			// System.out.println(i + "," + i + ": " + ii + "," + jj);

			if (ii == '?') {
				match[i][i] = true;
			} else if (ii == '*') {
				if (match[i - 1][i - 1]) {
					for (int k = i; k <= s.length() + 1; k++) {
						// if (i + 1 < p.length())
						if (isMatch(s.substring(k - 1), p.substring(i - 1 + 1))) {
							return true;
						}
					}
				}
				if (match[i - 1][i]) {
					for (int k = i; k <= s.length() + 1; k++) {
						if (isMatch(s.substring(k - 1), p.substring(i - 1 + 1))) {
							return true;
						}
					}

				}
				return false;

			} else {
				if (jj == ii)
					match[i][i] = true;
				else
					return false;

			}
		}

		return match[p.length()][s.length()];

	}

	private boolean allStar(String p) {
		for (int i = 0; i < p.length(); i++)
			if (p.charAt(i) != '*')
				return false;

		return true;
	}

	public boolean isMatchWrongDP(String s, String p) {
		if (p.length() == 0) {
			return false;
		}

		boolean[][] match = new boolean[p.length() + 1][s.length() + 1];
		match[0][0] = true;

		for (int i = 1; i <= p.length(); i++) {
			char ii = p.charAt(i - 1);
			for (int j = 1; j <= s.length(); j++) {
				char jj = s.charAt(j - 1);

				if (ii == '?') {
					if (match[i - 1][j - 1])
						match[i][j] = true;
				} else if (ii == '*') {
					if (match[i - 1][j] // *==null
							|| match[i - 1][j - 1] // *==ii
					) {
						for (int k = j; k <= s.length(); k++)
							match[i][k] = true;
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
