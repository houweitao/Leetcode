package hou.forwz.Leetcode.hard;

/**
 * @author houweitao
 * @date 2016年7月13日上午1:05:37
 */

public class InterleavingString2 {
	public static void main(String[] args) {
		InterleavingString2 il = new InterleavingString2();
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		System.out.println(il.isInterleave(s1, s2, s3));

	}

	public boolean isInterleave2(String s1, String s2, String s3) {
		if (s3.length() != s2.length() + s1.length())
			return false;

		if (s1.length() == 0)
			return s2.equals(s3);

		if (s2.length() == 0)
			return s1.equals(s3);

		boolean[][] table = new boolean[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < s1.length() + 1; i++)
			for (int j = 0; j < s2.length() + 1; j++) {
				if (i == 0 && j == 0)
					table[i][j] = true;
				else if (i == 0)
					table[i][j] = (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				else if (j == 0)
					table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1));
				else
					table[i][j] = (table[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
							|| (table[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
			}
		return table[s1.length()][s2.length()];
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		System.out.println(s1 + " + " + s2 + " = " + s3);
		if (s3.length() != s2.length() + s1.length())
			return false;

		if (s1.length() == 0)
			return s2.equals(s3);

		if (s2.length() == 0)
			return s1.equals(s3);

		char c = s3.charAt(0);

		boolean l = false, r = false;
		if (s2.charAt(0) == c)
			l = isInterleave(s1, s2.substring(1), s3.substring(1));

		if (l)
			return l;

		if (s1.charAt(0) == c)
			r = isInterleave(s1.substring(1), s2, s3.substring(1));

		if (r)
			return r;

		return false;

	}

}
