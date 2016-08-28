package hou.forwz.LeetcodeAgain.hard;

/**
 * @author houweitao
 * @date 2016年8月29日上午12:13:27
 */

public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
		InterleavingString is = new InterleavingString();
		System.out.println(is.isInterleave(s1, s2, s3));
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3.length() != s1.length() + s2.length())
			return false;
		if (s1.equals("") && s1.equals(s1) && s1.equals(s2))
			return true;

		boolean[][] is = new boolean[s1.length() + 1][s2.length() + 1];

		is[0][0] = true;
		for (int i = 1; i <= s1.length(); i++) {
			if (s1.charAt(i - 1) == s3.charAt(i - 1) && is[i - 1][0])
				is[i][0] = true;
			else
				break;
		}
		for (int i = 1; i <= s2.length(); i++) {
			if (s2.charAt(i - 1) == s3.charAt(i - 1) && is[0][i - 1])
				is[0][i] = true;
			else
				break;
		}

		for (int i = 1; i <= s1.length(); i++) {
			char shu = s1.charAt(i - 1);
			for (int j = 1; j <= s2.length(); j++) {
				char heng = s2.charAt(j - 1);

				char need = s3.charAt(i + j - 1);

				if (is[i - 1][j] && shu == need)
					is[i][j] = true;
				if (is[i][j - 1] && heng == need)
					is[i][j] = true;

			}
		}

//		print(is);

		return is[s1.length()][s2.length()];

	}

	private void print(boolean[][] is) {
		for (int i = 0; i < is.length; i++) {
			for (int j = 0; j < is[0].length; j++) {
				System.out.print(is[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public boolean isInterleaveTimeOut(String s1, String s2, String s3) {
		return simple(s1, 0, s2, 0, s3, 0);
	}

	private boolean simple(String s1, int i, String s2, int j, String s3, int k) {
		if (k == s3.length() && i == s1.length() && j == s2.length())
			return true;
		if (i == s1.length())
			return s2.substring(j).equals(s3.substring(k));
		if (j == s2.length())
			return s1.substring(i).equals(s3.substring(k));

		if (s1.charAt(i) == s3.charAt(k)) {
			if (simple(s1, i + 1, s2, j, s3, k + 1))
				return true;
		}
		if (s2.charAt(j) == s3.charAt(k)) {
			if (simple(s1, i, s2, j + 1, s3, k + 1))
				return true;
		}

		return false;
	}

}
