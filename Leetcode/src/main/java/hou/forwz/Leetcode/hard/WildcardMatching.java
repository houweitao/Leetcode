package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年8月7日上午12:15:42
 * @timeout
 */

public class WildcardMatching {
	public static void main(String[] args) {
		WildcardMatching wm = new WildcardMatching();
		System.out.println(wm.isMatch("cabcdefss", "c*?"));
	}

	public boolean isMatch(String s, String p) {
		System.out.println(s + "," + p);
		if (s.equals(p) || p.equals("*"))
			return true;
		else if (s.length() == 0) {
			if (p.equals("*"))
				return true;
			else
				return false;
		} else if (p.length() == 0)
			return p.equals(s);
		// else if (s.length() == 0 || p.length() > s.length())
		// return false;

		char pLast = p.charAt(p.length() - 1);
		char sLast = s.charAt(s.length() - 1);

		if (pLast != '?' && pLast != '*' && pLast != sLast)
			return false;

		for (int i = 0; i < s.length(); i++) {
			if (i >= p.length())
				return false;
			char left = s.charAt(i);
			char right = p.charAt(i);

			// if (right == '?')
			// continue;
			// else

			if (right == '*') {
				if (i == p.length() - 1)
					return true;
				for (int j = i; j < s.length(); j++) {
					if (isMatch(s.substring(j), p.substring(i + 1)))
						return true;
				}
				return false;
			} else if (right != '?') {
				if (left != right)
					return false;
			}

			if (i == s.length() - 1) {
				// System.out.println("....");
				if ((onlyStar(p.substring(i + 1)) || i == p.length() - 1)
						&& (left == right || right == '?' || right == '*'))
					return true;
				else
					return false;
			}
		}
		return true;
	}

	private boolean onlyStar(String str) {
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c != '*')
				return false;
		}

		return true;
	}

}
