package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月5日上午12:37:09
 */

public class AdditiveNumber {
	public static void main(String[] args) {
		AdditiveNumber add = new AdditiveNumber();
		System.out.println(add.isAdditiveNumber(1023 + ""));
	}

	public boolean isAdditiveNumber(String num) {

		for (int i = 0; i < num.length() - 2; i++) {
			String first = num.substring(0, i + 1);
			// System.out.println("first"+first);
			if (first.length() > 1 && first.charAt(0) == '0')
				continue;
			for (int j = i + 1; j < num.length() - 1; j++) {
				String second = num.substring(i + 1, j + 1);
				if (second.length() > 1 && second.charAt(0) == '0')
					continue;
				// System.out.println(first+","+second);
				if (valid(num.substring(j + 1), Long.valueOf(first), Long.valueOf(second))) {
					return true;
				}

			}
		}
		return false;
	}

	private boolean valid(String str, Long a, Long b) {
		// System.out.println(str + "," + a + "," + b);
		String res = (a + b) + "";
		if (str.equals(res))
			return true;
		for (int i = 0; i < str.length(); i++) {
			// System.out.println("?? "+str.substring(0, i + 1)+","+res);
			if (str.substring(0, i + 1).equals(res)) {
				return valid(str.substring(i + 1), b, Long.valueOf(str.substring(0, i + 1)));
			}
		}

		return false;
	}

}
