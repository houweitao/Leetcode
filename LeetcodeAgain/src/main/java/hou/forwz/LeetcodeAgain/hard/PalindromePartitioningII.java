package hou.forwz.LeetcodeAgain.hard;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houweitao
 * @date 2016年8月25日下午4:10:19
 * @timeOut 2016年08月25日16:42:12
 * @end 2016年08月25日16:59:07
 */

public class PalindromePartitioningII {
	Map<String, Boolean> record = new HashMap<>();

	public static void main(String[] args) {
		PalindromePartitioningII pp = new PalindromePartitioningII();
		String s = "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece";
		System.out.println(pp.minCut(s));

	}

	public int minCut(String s) {
		int[] cut = new int[s.length() + 1];
		cut[0] = 0;
		for (int i = 1; i <= s.length(); i++) {
			cut[i] = i - 1;
		}

		boolean[][] dp = new boolean[s.length()][s.length()];
		for (int i = 0; i < dp.length; i++)
			dp[i][i] = true;
		for (int i = 0; i < dp.length - 1; i++) {
			if (s.charAt(i) == s.charAt(i + 1))
				dp[i][i + 1] = true;
		}
		// for (int i = 0; i < s.length(); i++) {
		for (int i = s.length() - 1; i >= 0; i--) {
			for (int j = 2; i + j < s.length(); j++) {
				// System.out.println(i + "," + (i + j));
				if (dp[i + 1][i + j - 1] && s.charAt(i) == s.charAt(i + j))
					dp[i][i + j] = true;
			}
		}

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= i; j++) {
				// String cur = s.substring(j - 1, i);
				if (dp[j - 1][i - 1]) {
					// if (is(cur)) {
					int maybe;
					if (j - 1 == 0)
						maybe = 0;
					else
						maybe = cut[j - 1] + 1;
					cut[i] = Math.min(cut[i], maybe);
				}
			}
		}

		// for (int i = 0; i < cut.length; i++)
		// System.out.println(i + "," + cut[i]);

		return cut[cut.length - 1];
	}

	private boolean is(String cur) {
		if (cur.length() < 2)
			return true;
		else if (record.containsKey(cur))
			return record.get(cur);
		else {
			int left = 0, right = cur.length() - 1;
			while (left < right) {
				if (cur.charAt(left) != cur.charAt(right)) {
					record.put(cur, false);
					return false;
				}
				left++;
				right--;
			}
			record.put(cur, true);
			return true;
		}
	}

}
