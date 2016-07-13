package hou.forwz.Leetcode.medium;

/**
 * @author houweitao
 * @date 2016年7月13日下午10:34:14
 */

public class DecodeWays {
	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("110"));
	}

	public int numDecodings(String s) {
		if (s.length() == 0)
			return 0;

		if (s.charAt(0) == '0')
			return 0;

		int[] num = new int[s.length() + 1];
		num[0] = 1;
		num[1] = 1;

		for (int i = 2; i <= s.length(); i++) {
			String maybe = s.substring(i - 2, i);
			int cur = Integer.valueOf(maybe);

			if (cur==0||cur > 26 && cur % 10 == 0)
				num[i] = 0;
			else if (cur < 10) {
				num[i] = num[i - 1];
				if (num[i] == 0)
					return 0;
			} else if (cur <= 26 && cur>= 10) {
				if (cur == 20||cur==10) {
					num[i] = num[i - 2];
					if (num[i] == 0)
						return 0;
				} else {
					int one = num[i - 2];
					int two = num[i - 1];
					num[i] = one + two;
				}
			} else
				num[i] = num[i - 1];

		}

		return num[s.length()];
	}

}
