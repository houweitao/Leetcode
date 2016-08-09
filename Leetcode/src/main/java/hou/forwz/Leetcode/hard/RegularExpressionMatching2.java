package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月10日上午12:34:31
 */

public class RegularExpressionMatching2 {
	public static void main(String[] args) {
		RegularExpressionMatching2 re = new RegularExpressionMatching2();
		String s = "aab";
		String p = "c*a*b";
		System.out.println(re.isMatch(s, p));
	}

	public boolean isMatchDPMe(String s, String p) {
		if (s == null || p == null)
			return false;
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1])
				dp[0][i + 1] = true;
		}

		for (int i = 0; i < s.length(); i++) {

			for (int j = 0; j < p.length(); j++) {
				char c = p.charAt(j);

				if (c == '.')
					dp[i + 1][j + 1] = dp[i][j];
				else if (c == s.charAt(i))
					dp[i + 1][j + 1] = dp[i][j];
				if ('*' == s.charAt(i)) {
					// *
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = dp[i + 1][j] || dp[i + 1][j - 1] || dp[i][j + 1];
					}
				}
			}
		}

		return dp[s.length()][p.length()];

	}

	// https://discuss.leetcode.com/topic/40371/easy-dp-java-solution-with-detailed-explanation
	public boolean isMatchDP(String s, String p) {

		if (s == null || p == null) {
			return false;
		}
		boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;
		for (int i = 0; i < p.length(); i++) {
			if (p.charAt(i) == '*' && dp[0][i - 1]) {
				dp[0][i + 1] = true;
			}
		}
		for (int i = 0; i < s.length(); i++) {
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '.') {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == s.charAt(i)) {
					dp[i + 1][j + 1] = dp[i][j];
				}
				if (p.charAt(j) == '*') {
					if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
						dp[i + 1][j + 1] = dp[i + 1][j - 1];
					} else {
						dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
					}
				}
			}
		}
		return dp[s.length()][p.length()];
	}

	public boolean isMatch(String s, String p) {
		Trie trie = build(s);
		Trie node = trie.next;

		if (node == null) {
			if (p.length() == 0)
				return false;
			for (int i = 0; i < p.length(); i++) {
				if (p.charAt(i) != '*')
					return false;
			}
			return true;
		}

		return node.match(p);

	}

	private Trie build(String s) {
		Trie ret = new Trie('$');
		Trie node = ret;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			Trie cur = new Trie(c);
			node.next = cur;
			node = cur;
		}
		return ret;
	}

	class Trie {
		char val;
		Trie next;

		Trie(char c) {
			val = c;
		}

		boolean match(String str) {
			// System.out.println("new: " + val + ":" + str);

			Trie node = this;
			if (str.length() == 0)
				return false;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				if (c == '.') {
					if (i == str.length() - 1)
						return node.next == null;
					node = node.next;
				} else if (c == '*') {
					if (i == str.length() - 1)
						return true;
					while (node != null) {
						if (node.match(str.substring(i + 1)))
							return true;
						node = node.next;
					}
					return false;
				} else {
					// System.out.println("node: "+node.val+" char:"+c);
					if (node.val == c) {// 这里一定要用 node.val！！！
						// System.out.println("==" + c);
						// System.out.println("i: " + i + ", all:" +
						// (str.length()-1));
						if (i == (str.length() - 1)) {
							// System.out.println("?");
							return node.next == null;
						} else
							node = node.next;
					}

					// else
					// return false;

				}

				if (node == null)
					return false;
			}

			return false;
		}
	}
}
