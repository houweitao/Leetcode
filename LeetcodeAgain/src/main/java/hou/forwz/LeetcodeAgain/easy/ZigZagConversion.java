package hou.forwz.LeetcodeAgain.easy;

/**
 * @author houweitao
 * @date 2016年9月14日上午10:38:55
 */

public class ZigZagConversion {

	public String convert(String s, int numRows) {
		if (numRows < 1)
			return null;
		else if (numRows == 1)
			return s;
		else {
			StringBuilder[] sb = new StringBuilder[numRows];

			for (int j = 0; j < numRows; j++) {
				sb[j] = new StringBuilder();
			}

			for (int i = 0; i < s.length();) {
				for (int j = 0; j < numRows; j++) {
					sb[j].append(s.charAt(i));
					i++;
					if (i == s.length())
						break;
				}
				if (i == s.length())
					break;
				for (int j = numRows - 2; j > 0; j--) {
					sb[j].append(s.charAt(i));
					i++;
					if (i == s.length())
						break;
				}
				if (i == s.length())
					break;
			}

			StringBuilder ret = new StringBuilder();
			for (StringBuilder str : sb) {
//				System.out.println(str);
				ret.append(str.toString());
			}
			return ret.toString();
		}
	}

}
