package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年9月16日上午11:12:28
 */

public class RegularExpressionMatching3 {
	public static void main(String[] args) {
		RegularExpressionMatching3 re = new RegularExpressionMatching3();
		String s = "aab";
		String p = "c*a*b";
		// System.out.println(re.isMatch(s, p));
		System.out.println(re.isMatchMe(s, p));
	}

	public boolean isMatchMe(String s, String p) {
//		System.out.println(s + "," + p);

		if (p.length() == 0)
			return s.length() == 0;
		else if (s.equals(p))
			return true;
		else if (p.length() == 1) {
			if (s.length() != 1)
				return false;
			else if (p.length() == '*' && s.length() == 0 || p.charAt(0) == '.')
				return true;
			else
				return false;
		} else {
			// if (p.length() >= 2) {
			if (p.charAt(1) == '*') {
				if (isMatchMe(s, p.substring(2)))
					return true;
				if (s.length() > 0) {
					while ((s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
//						System.out.println("??" + s + "," + p.substring(2));
						if (isMatchMe(s, p.substring(2))) {
							return true;
						}
						s = s.substring(1);
//						System.out.println("change " + s + "," + p);
						if (s.length() == 0) {
//							System.out.println("length  " + s);
							return isMatchMe(s, p.substring(2));
						}
					}
					
					if (isMatchMe(s, p.substring(2))) {
						return true;
					}
				}

				return false;
			} else {
				if (s.length() > 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'))
					return isMatchMe(s.substring(1), p.substring(1));
				else
					return false;
			}
			// }
		}
	}

	public boolean isMatch(String s, String p) {
		if (p.isEmpty()) {
			return s.isEmpty();
		}

		if (p.length() == 1 || p.charAt(1) != '*') {
			if (s.isEmpty() || (p.charAt(0) != '.' && p.charAt(0) != s.charAt(0))) {
				return false;
			} else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}

		// P.length() >=2
		while (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.')) {
			if (isMatch(s, p.substring(2))) {
				return true;
			}
			s = s.substring(1);
		}

		return isMatch(s, p.substring(2));
	}
}
