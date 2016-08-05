package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年8月5日下午10:54:35
 */

public class MultiplyStrings2 {
	public static void main(String[] args) {
		MultiplyStrings2 ms = new MultiplyStrings2();
		String num1 = "92345";
		String num2 = "-2";
		System.out.println(ms.multiply(num1, num2));
		System.out.println(92345 * 678);
	}

	public String multiply(String num1, String num2) {
		if (num1.length() == 0 || num2.length() == 0)
			return "";
		else if (num1.charAt(0) == '-' && num2.charAt(0) == '-')
			return multiply(num1.substring(1), num2.substring(1));
		else if (num1.charAt(0) == '-') {
			return "-" + multiply(num1.substring(1), num2);
		} else if (num2.charAt(0) == '-')
			return "-" + multiply(num1, num2.substring(1));

		int[][] help = new int[num2.length()][num1.length() + num2.length()];
		int chang = help[0].length;

		for (int i = 0; i < num2.length(); i++) {
			int iPos = num2.length() - i - 1;
			int fir = num2.charAt(iPos) - '0';
			int add = 0;
			for (int j = 0; j < num1.length(); j++) {
				int jPos = num1.length() - 1 - j;
				int sec = num1.charAt(jPos) - '0';
				int cur = fir * sec + add;

				// System.out
				// .println(cur + "=" + fir + "*" + sec + " " + "help[" + i +
				// "][" + (chang - j - i - 1) + "]");

				help[i][chang - j - i - 1] = cur % 10;
				add = cur / 10;
			}
			help[i][chang - i - num1.length() - 1] = add;

			// print(help[i]);
		}

		int add = 0;
		int[] ret = new int[chang];
		for (int i = chang - 1; i >= 0; i--) {
			int sum = add;
			for (int j = 0; j < help.length; j++) {
				sum = sum + help[j][i];
			}
			ret[i] = sum % 10;
			add = sum / 10;
		}

		boolean start = false;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < ret.length; i++) {
			if (!start && ret[i] == 0)
				continue;
			else {
				sb.append(ret[i]);
				start = true;
			}
		}
		if (sb.length() == 0)
			return "0";
		else
			return sb.toString();
	}

	private void print(int[] is) {
		for (int i : is)
			System.out.print(i);
		System.out.println();
	}

}
