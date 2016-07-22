package hou.forwz.Leetcode.easy;

/**
 * @author houweitao
 * @date 2016年7月23日上午1:53:50
 */

public class CountPrimes {

	public int countPrimes(int n) {
		if (n < 2)
			return 0;

		boolean[] judge = new boolean[n + 1];

		int count = 0;
		for (int i = 2; i < n; i++) {
			if (!judge[i]) {
				judge[i] = true;
				count++;
				for (int j = 2; j * i < n; j++) {
					judge[i * j] = true;
				}
			}

		}
		return count;
	}

}
