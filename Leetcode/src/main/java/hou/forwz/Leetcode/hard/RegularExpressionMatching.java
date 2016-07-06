package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月6日下午10:04:57
 */

public class RegularExpressionMatching {
	public boolean isMatch(String s, String p) {
		if (s == p)
			return true;
		else if (p == null || p.length() == 0)
			return false;
		else if (s == null || s.length() == 0) {
			if (p == "." || p == ".*")// TODO
				return true;
			else
				return false;
		} else {
			String reg = deal(p);
			String nextP = p.substring(reg.length() - 1);
			if (reg.length() == 0) {
				return false;
			} else if (reg.length() == 1) {
				if (reg == ".") {
					return isMatch(s.substring(1), nextP);
				} else {
					if ((s.charAt(0) + "") == reg)
						return isMatch(s.substring(1), nextP);
					else
						return false;
				}
			} else {
				if ((reg.charAt(0) + "") == ".") {
					for (int i = 0; i < s.length(); i++) {
						if (isMatch(s.substring(i), nextP))
							return true;
					}
					return false;
				} else {
					if (s.charAt(0) == p.charAt(0))
						for (int i = 0; i < s.length(); i++) {
							if (s.charAt(i) == p.charAt(0) && isMatch(s.substring(i), nextP))// can
																								// better
								return true;
						}

					return false;
				}
			}
		}
	}

	private String deal(String p) {
		if (p.length() == 1)
			return p;
		else if (p == null || p.length() == 0)
			return p;
		else {
			if (p.charAt(1) == '*')
				return p.substring(0, 2);
			else
				return p.charAt(0) + "";

		}
	}

}
