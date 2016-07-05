package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月6日上午1:34:57
 */

public class ZigZagConversion {
	public static void main(String[] args) {
		ZigZagConversion zz = new ZigZagConversion();
		System.out.println(zz.convert("abcd", 3));
	}

	public String convert(String s, int numRows) {

		if (s.length() < 2)
			return s;
		if (numRows == 1)
			return s;
		if (numRows == 2) {
			String up = "", down = "";

			for (int i = 0; i < s.length(); i++) {
				if (i % 2 == 0)
					up = up + s.charAt(i);
				else
					down = down + s.charAt(i);
			}

			return up + down;
		}

		int len = s.length();

		int yu = len % (numRows * 2 - 2);
		int hang = len / (numRows * 2 - 2);
		int lie = 0;

		lie = hang * 2;
		if (yu > 0 && yu < numRows)
			lie = lie + 1;
		else if (yu >= numRows)
			lie = lie + 2;

		char[][] nums = new char[numRows][lie];

		int k = 0;
		for (int i = 0; i < lie; i++) {
			for (int j = 0; j < numRows; j++) {
				if (i % 2 == 1 && (j == 0 || j == lie - 1))
					continue;
				nums[j][i] = s.charAt(k++);
				if (k > len - 1)
					return print(nums, len);
			}
		}

		return null;
	}

	private String print(char[][] nums, int len) {
		String ret = "";
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (!(j % 2 == 1 && (i == 0 || i == nums[0].length - 1)))
					ret = ret + nums[i][j] + "";
			}
		}

		return ret.substring(0, len);
	}

}
