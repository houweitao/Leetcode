package hou.forwz.Leetcode.hard;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author houweitao
 * @date 2016年7月25日下午10:01:40
 */

public class RussianDollEnvelopes {
	public static void main(String[] args) {
		RussianDollEnvelopes rd = new RussianDollEnvelopes();
		int[][] envelopes = { { 7, 8 }, { 12, 16 }, { 12, 5 }, { 1, 8 }, { 4, 19 }, { 3, 15 }, { 4, 10 }, { 9, 16 } };
		System.out.println(rd.maxEnvelopes(envelopes));
	}

	public int maxEnvelopes(int[][] envelopes) {
		if (envelopes.length < 2)
			return envelopes.length;

		RussianDoll[] dolls = new RussianDoll[envelopes.length];
		for (int i = 0; i < envelopes.length; i++) {
			dolls[i] = new RussianDoll(envelopes[i][0], envelopes[i][1]);
		}

		Arrays.sort(dolls, new RDComparator());

//		for (int i = 0; i < dolls.length; i++)
//			System.out.print(dolls[i] + ",");
//		System.out.println();

		int[] dp = new int[dolls.length];
		for (int i = 0; i < dp.length; i++)
			dp[i] = 1;

		int max = 1;
		for (int i = 1; i < dolls.length; i++) {
			int cur = 1;

			for (int j = i - 1; j >= 0; j--) {
				if (bigger(dolls[i], dolls[j])) {
					cur = Math.max(cur, dp[j] + 1);
				}
			}

			dp[i] = cur;
			max = Math.max(max, cur);
		}

//		for (int i = 0; i < dp.length; i++)
//			System.out.println(i + "," + dp[i]);

		return max;
	}

	private boolean bigger(RussianDoll left, RussianDoll right) {
		if (left.width > right.width && left.height > right.height)
			return true;
		else
			return false;
	}

	class RDComparator implements Comparator<RussianDoll> {

		@Override
		public int compare(RussianDoll o1, RussianDoll o2) {
			int gap = o1.width - o2.width;
			return gap;
		}

	}

	class RussianDoll {
		int width;
		int height;

		RussianDoll(int x, int y) {
			width = x;
			height = y;
		}

		@Override
		public String toString() {
			return "[" + width + "," + height + "]";
		}

	}
}
