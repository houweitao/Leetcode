package hou.forwz.Leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author houweitao
 * @date 2016年7月26日上午1:21:24
 */

public class BullsAndCows {

	public String getHint(String secret, String guess) {
		int bulls = 0, cows = 0;
		int[] a = new int[10];
		int[] b = new int[10];
		for (int i = 0; i < secret.length(); i++) {
			int s = secret.charAt(i) - '0';
			int g = guess.charAt(i) - '0';

			if (s == g)
				bulls++;
			else {
				a[s]++;
				b[g]++;
			}
		}

		for (int i = 0; i < 10; i++) {
			cows = cows + Math.min(a[i], b[i]);
		}

		return bulls + "A" + cows + "B";
	}

}
