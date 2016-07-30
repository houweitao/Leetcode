package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月31日上午12:10:43
 */

public class ValidNumber {
	public static void main(String[] args) {
		ValidNumber vn = new ValidNumber();
		System.out.println(vn.isNumber("+.8"));
	}

	public boolean isNumber(String s) {
		s = s.trim();

		boolean firstDot = true;
		boolean firstE = true;
		boolean firstFuhao = true;
		boolean hasDigit = false;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
//			 System.out.println(c + ", " + firstDot + "," + firstE);
			if (Character.isDigit(c))
				hasDigit = true;

			if (i == 0) {
				if (Character.isDigit(c) || c == '-' || c == '.'|| c == '+') {
					if (c == '.')
						firstDot = false;
					if (c == '-' || c == '+')
						firstFuhao = false;
				} else
					return false;
			} else {
				if (c == '.') {
					if (!(firstE && firstDot)) {
//						System.out.println("!!");
						return false;
					} else
						firstDot = false;
				} else if (c == 'e') {
					if (!(firstE && firstDot)) {
						// System.out.println("??" + firstE + "," + firstDot);
						return false;
					} else
						firstE = false;
				} else if (!Character.isDigit(c)) {
//					System.out.println("---");
					return false;
				}
			}

		}

		if (!hasDigit)
			return false;
		if (s.charAt(s.length() - 1) == 'e')
			return false;

		return true;
	}

}
